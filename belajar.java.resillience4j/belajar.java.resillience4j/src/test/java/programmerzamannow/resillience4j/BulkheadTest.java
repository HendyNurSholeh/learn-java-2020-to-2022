package programmerzamannow.resillience4j;

import io.github.resilience4j.bulkhead.*;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.atomic.AtomicLong;
import java.util.function.Supplier;

@Slf4j
public class BulkheadTest {

    private AtomicLong aLong = new AtomicLong(0L);

    @SneakyThrows
    void task(){
        long counter = aLong.incrementAndGet();
        log.info("task : " + counter);
        Thread.sleep(5000);
    }

    @Test
    void createBulkhead() {
        Bulkhead bulkhead = Bulkhead.ofDefaults("hyns");
        Runnable runnable = Bulkhead.decorateRunnable(bulkhead, () -> task());
        for (int i = 0; i < 100; i++) {
            new Thread(runnable).start();
        }
    }

    @Test
    @SneakyThrows
    void createThreadpoolBulkhead() {
        ThreadPoolBulkhead threadPoolBulkhead  = ThreadPoolBulkhead.ofDefaults("hyns");
        Supplier<CompletionStage<Void>> runnable = ThreadPoolBulkhead.decorateRunnable(threadPoolBulkhead, () -> task());
        for (int i = 0; i < 100; i++) {
            runnable.get();
        }
        Thread.sleep(10_000);
    }

    @Test
    @SneakyThrows
    void BulkheadWithConfig() {
        BulkheadConfig bulkheadConfig = BulkheadConfig.custom()
                .maxConcurrentCalls(10)
                .maxWaitDuration(Duration.ofSeconds(15))
                .build();
        Bulkhead bulkhead = Bulkhead.of("hyns", bulkheadConfig);
        Runnable runnable = Bulkhead.decorateRunnable(bulkhead, () -> task());
        for (int i = 0; i < 100; i++) {
            new Thread(runnable).start();
        }
        Thread.sleep(100000);
    }

    @Test
    @SneakyThrows
    void ThreadpoolBulkheadConfigTest() {
        ThreadPoolBulkheadConfig threadPoolBulkheadConfig = ThreadPoolBulkheadConfig.custom()
                .maxThreadPoolSize(3)
                .coreThreadPoolSize(3)
                .build();
        ThreadPoolBulkhead threadPoolBulkhead = ThreadPoolBulkhead.of("hyns", threadPoolBulkheadConfig);
        Supplier<CompletionStage<Void>> runnable = ThreadPoolBulkhead.decorateRunnable(threadPoolBulkhead, () -> task());
        for (int i = 0; i < 100; i++) {
            runnable.get();
        }
        Thread.sleep(100000);
    }

    @Test
    @SneakyThrows
    void testBulkheadRegistry() {
        BulkheadRegistry bulkheadRegistry = BulkheadRegistry.ofDefaults();
        BulkheadConfig bulkheadConfig = BulkheadConfig.custom()
                .maxConcurrentCalls(10)
                .maxWaitDuration(Duration.ofSeconds(3))
                .build();
        bulkheadRegistry.addConfiguration("config", bulkheadConfig);
        Bulkhead bulkhead = bulkheadRegistry.bulkhead("hyns", "config");
        Runnable runnable = Bulkhead.decorateRunnable(bulkhead, () -> task());
        for (int i = 0; i < 100; i++) {
            new Thread(runnable).start();
        }
        Thread.sleep(10000);
    }

    @Test
    @SneakyThrows
    void createThreadpoolBulkheadRegistry() {
        ThreadPoolBulkheadRegistry registry = ThreadPoolBulkheadRegistry.ofDefaults();
        ThreadPoolBulkheadConfig bulkheadConfig = ThreadPoolBulkheadConfig.custom()
                .maxThreadPoolSize(10)
                .coreThreadPoolSize(10)
                .keepAliveDuration(Duration.ofSeconds(4))
                .build();
        registry.addConfiguration("config", bulkheadConfig);
        ThreadPoolBulkhead bulkhead = registry.bulkhead("hyns", "config");
        for (int i = 0; i < 100; i++) {
            Supplier<CompletionStage<Void>> supplier = bulkhead.decorateRunnable(() -> task());
            supplier.get();
        }
        Thread.sleep(30000);
    }
}
