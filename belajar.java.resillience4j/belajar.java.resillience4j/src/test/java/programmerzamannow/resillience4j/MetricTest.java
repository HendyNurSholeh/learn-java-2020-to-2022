package programmerzamannow.resillience4j;

import io.github.resilience4j.retry.Retry;
import io.github.resilience4j.retry.RetryConfig;
import io.github.resilience4j.retry.RetryRegistry;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.util.concurrent.atomic.AtomicLong;
import java.util.function.Supplier;

@Slf4j
public class MetricTest {

    private AtomicLong counter = new AtomicLong(0L);

    String repository(){
        log.info("call : " + counter.incrementAndGet());
        throw new RuntimeException("error repository");
    }

    @Test
    void metricInRetry() {
        RetryRegistry retryRegistry = RetryRegistry.ofDefaults();
        RetryConfig config = RetryConfig.custom()
                .maxAttempts(3)
                .waitDuration(Duration.ofSeconds(1))
                .build();
        retryRegistry.addConfiguration("config1", config);
        Retry retry = retryRegistry.retry("hyns", "config1");
        Supplier<String> supplier = Retry.decorateSupplier(retry, () -> repository());
        for (int i = 0; i < 5; i++) {
            try {
                supplier.get();
            } catch (Exception e) {
                log.info("error");
                log.info(String.valueOf(retry.getMetrics().getNumberOfFailedCallsWithoutRetryAttempt()));
                log.info(String.valueOf(retry.getMetrics().getNumberOfFailedCallsWithRetryAttempt()));
                log.info(String.valueOf(retry.getMetrics().getNumberOfSuccessfulCallsWithoutRetryAttempt()));
                log.info(String.valueOf(retry.getMetrics().getNumberOfSuccessfulCallsWithRetryAttempt()));
            }
        }
    }
}
