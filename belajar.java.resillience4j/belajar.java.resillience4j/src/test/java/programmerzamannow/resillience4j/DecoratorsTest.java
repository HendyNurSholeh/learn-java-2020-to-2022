package programmerzamannow.resillience4j;

import io.github.resilience4j.decorators.Decorators;
import io.github.resilience4j.ratelimiter.RateLimiter;
import io.github.resilience4j.ratelimiter.RateLimiterConfig;
import io.github.resilience4j.ratelimiter.RateLimiterRegistry;
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
public class DecoratorsTest {

    private AtomicLong counter = new AtomicLong(0L);

    void databseRepository(){
      log.info("call database : " + counter.incrementAndGet());
      throw new RuntimeException("ups : " + counter.get());
    }

    String databseRepository2(){
        log.info("call database : " + counter.incrementAndGet());
        throw new RuntimeException("ups : " + counter.get());
    }

    @Test
    @SneakyThrows
    void createDecoratorsRetryAndRateLimiter() {
        RetryRegistry retryRegistry = RetryRegistry.ofDefaults();
        RateLimiterRegistry rateLimiterRegistry = RateLimiterRegistry.ofDefaults();
        Retry retry = retryRegistry.retry("hyns", RetryConfig.custom()
                .maxAttempts(4)
                .waitDuration(Duration.ofSeconds(0))
                .build());
        RateLimiter rateLimiter = rateLimiterRegistry.rateLimiter("hyns", RateLimiterConfig.custom()
                .limitForPeriod(10)
                .timeoutDuration(Duration.ofSeconds(0))
                .limitRefreshPeriod(Duration.ofSeconds(10))
                .build());

        Runnable runnable = Decorators.ofRunnable(() -> databseRepository())
                .withRetry(retry)
                .withRateLimiter(rateLimiter)
                .decorate();

        for (int i = 0; i < 100; i++) {
            new Thread(runnable).start();
        }
        Thread.sleep(10000);
    }

    @Test
    @SneakyThrows
    void fallBack() {
        RetryRegistry retryRegistry = RetryRegistry.ofDefaults();
        RateLimiterRegistry rateLimiterRegistry = RateLimiterRegistry.ofDefaults();
        Retry retry = retryRegistry.retry("hyns", RetryConfig.custom()
                .maxAttempts(4)
                .waitDuration(Duration.ofSeconds(0))
                .build());
        RateLimiter rateLimiter = rateLimiterRegistry.rateLimiter("hyns", RateLimiterConfig.custom()
                .limitForPeriod(10)
                .timeoutDuration(Duration.ofSeconds(0))
                .limitRefreshPeriod(Duration.ofSeconds(10))
                .build());

        Supplier<String> decorate = Decorators.ofSupplier(() -> databseRepository2())
                .withRetry(retry)
                .withRateLimiter(rateLimiter)
                .withFallback(throwable -> "fallback")
                .decorate();

        for (int i = 0; i < 100; i++) {
            log.info(decorate.get());
        }
        Thread.sleep(10000);
    }
}
