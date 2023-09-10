package programmerzamannow.resillience4j;

import io.github.resilience4j.retry.Retry;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.amqp.RabbitProperties;

import java.util.concurrent.Callable;
import java.util.function.Supplier;

@Slf4j
public class RetryTest {

    @Test
    String task() {
        log.info("dieksekusi");
        throw new IllegalArgumentException("upsss eror");
    }

    @Test
    @SneakyThrows
    void createNewRetry() {
        Retry retry = Retry.ofDefaults("hendy");
        Runnable runnable = Retry.decorateRunnable(retry, () -> task());
        runnable.run();
    }

    @Test
    void createRetrySupplier() {
        var retry = Retry.ofDefaults("hyns");
        Supplier<String> supplier = Retry.decorateSupplier(retry, () -> task());
        supplier.get();
    }
}
