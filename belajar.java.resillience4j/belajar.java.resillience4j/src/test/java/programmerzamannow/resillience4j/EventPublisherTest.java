package programmerzamannow.resillience4j;

import io.github.resilience4j.ratelimiter.RateLimiter;
import io.github.resilience4j.ratelimiter.RateLimiterConfig;
import io.github.resilience4j.ratelimiter.RateLimiterRegistry;
import io.github.resilience4j.retry.Retry;
import io.github.resilience4j.retry.RetryConfig;
import io.github.resilience4j.retry.RetryRegistry;
import io.vavr.CheckedFunction0;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.util.concurrent.atomic.AtomicLong;
import java.util.function.Supplier;

@Slf4j
public class EventPublisherTest {

    private AtomicLong counter = new AtomicLong(0L);

    String todoService2() {
        log.info("todo : " + counter.incrementAndGet());
        throw new RuntimeException();
    }

    String todoService() {
      log.info("todo : " + counter.incrementAndGet());
      return "todo";
    }

    @Test
    void eventPublisherInRetry() {
        RetryRegistry retryRegistry = RetryRegistry.ofDefaults();
        RetryConfig retryConfig = RetryConfig.custom()
                .maxAttempts(3)
                .waitDuration(Duration.ofSeconds(0))
                .build();
        retryRegistry.addConfiguration("config1", retryConfig);
        Retry retry = retryRegistry.retry("hyns", "config1");
        retry.getEventPublisher().onRetry(event -> log.info("onRetry"));
        Supplier<String> supplier = Retry.decorateSupplier(retry, () -> todoService2());
        for (int i = 0; i < 10; i++) {
            supplier.get();
        }
    }

    @Test
    @SneakyThrows
    void eventPublisherInRateLimiter() {
        RateLimiterRegistry limiterRegistry = RateLimiterRegistry.ofDefaults();
        RateLimiterConfig limiterConfig = RateLimiterConfig.custom()
                .limitForPeriod(10)
                .limitRefreshPeriod(Duration.ofSeconds(3))
                .timeoutDuration(Duration.ofSeconds(0))
                .build();
        limiterRegistry.addConfiguration("config1", limiterConfig);
        RateLimiter rateLimiter = limiterRegistry.rateLimiter("hyns", "config1");
        rateLimiter.getEventPublisher().onSuccess(event -> log.info("onSucces : " + event));
        Supplier<String> supplier = RateLimiter.decorateSupplier(rateLimiter, () -> todoService());
        for (int i = 0; i < 20; i++) {
            Thread.sleep(100);
            supplier.get();
        }
    }
}