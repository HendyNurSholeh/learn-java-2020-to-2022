package programmerzamannow.resillience4j;

import io.github.resilience4j.timelimiter.TimeLimiter;
import io.github.resilience4j.timelimiter.TimeLimiterConfig;
import io.github.resilience4j.timelimiter.TimeLimiterRegistry;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.cache.interceptor.CacheOperationInvoker;

import java.time.Duration;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicLong;
import java.util.function.Supplier;

@Slf4j
public class TimeLimiterTest {

    private final AtomicLong counter = new AtomicLong(0L);


    @SneakyThrows
    public String task() {
        long result = counter.incrementAndGet();
        log.info("task : " + result + " is running");
        Thread.sleep(5000);
        log.info("task : " + result + " is done");
        return "task" + result;
    }

    @Test
    @SneakyThrows
    void createTimeLimiter() {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<String> future = executorService.submit(() -> task());
        TimeLimiter timeLimiter = TimeLimiter.ofDefaults("hyns");
        Callable<String> callable = timeLimiter.decorateFutureSupplier(() -> future);
        Thread.sleep(4000);
        callable.call();
    }

    @Test
    @SneakyThrows
    void timeLimiterConfig() {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        Future<String> future = executorService.submit(() -> task());
        TimeLimiterConfig timeLimiterConfig = TimeLimiterConfig.custom()
                .timeoutDuration(Duration.ofMillis(5000))
                .cancelRunningFuture(true).build();
        TimeLimiter timeLimiter = TimeLimiter.of("hyns", timeLimiterConfig);
        Callable<String> callable = TimeLimiter.decorateFutureSupplier(timeLimiter, () -> future);
        callable.call();
    }

    @Test
    @SneakyThrows
    void timeLimiterRegistry() {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<String> future = executorService.submit(() -> task());
        TimeLimiterRegistry timeLimiterRegistry = TimeLimiterRegistry.ofDefaults();
        TimeLimiter timeLimiter = timeLimiterRegistry.timeLimiter("hyns");
        Callable<String> callable = TimeLimiter.decorateFutureSupplier(timeLimiter, () -> future);
        callable.call();
    }

    @Test
    @SneakyThrows
    void timeLimiterRegistryWithConfig() {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<String> future = executorService.submit(() -> task());
        Thread.sleep(5000);
        TimeLimiterRegistry timeLimiterRegistry = TimeLimiterRegistry.ofDefaults();
        TimeLimiterConfig config = TimeLimiterConfig.custom()
                .timeoutDuration(Duration.ofSeconds(1))
                .cancelRunningFuture(true)
                .build();
        timeLimiterRegistry.addConfiguration("config1", config);
        TimeLimiter timeLimiter = timeLimiterRegistry.timeLimiter("hyns", config);
        Callable<String> callable = TimeLimiter.decorateFutureSupplier(timeLimiter, () -> future);
        callable.call();
    }
}

    