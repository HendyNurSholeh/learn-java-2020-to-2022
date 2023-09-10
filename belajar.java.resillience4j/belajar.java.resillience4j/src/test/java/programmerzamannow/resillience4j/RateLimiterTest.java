package programmerzamannow.resillience4j;

import io.github.resilience4j.ratelimiter.RateLimiter;
import io.github.resilience4j.ratelimiter.RateLimiterConfig;
import io.github.resilience4j.ratelimiter.RateLimiterRegistry;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.util.concurrent.atomic.AtomicLong;

@Slf4j
public class RateLimiterTest {

    private final AtomicLong aLong = new AtomicLong(0L);

    private RateLimiter rateLimiter;
    private RateLimiterConfig limiterConfig;
    private RateLimiter rateLimiterWithConfig;

    @BeforeEach
    void setUp() {
        rateLimiter = RateLimiter.ofDefaults("rate");
        limiterConfig = RateLimiterConfig.custom()
                .limitForPeriod(750)
                .limitRefreshPeriod(Duration.ofSeconds(8))
                .timeoutDuration(Duration.ofSeconds(5))
                .build();
        rateLimiterWithConfig = RateLimiter.of("rateConfig", limiterConfig);

    }


    @Test
    void createRateLimiter(){
        Runnable runnable = RateLimiter.decorateRunnable(rateLimiter, () -> {
            long result = aLong.incrementAndGet();
            log.info("Result {}", result);
        });
        for (int i = 0; i < 10000; i++) {
            runnable.run();
        }
    }

    @Test
    void createRateLimiterWithConfig(){
        Runnable runnable = RateLimiter.decorateRunnable(rateLimiterWithConfig, () -> {
            long result = aLong.incrementAndGet();
            log.info("Result {}", result);
        });
        for (int i = 0; i < 10000; i++) {
            runnable.run();
        }
    }

    @Test
    void rateLimiterRegistry() {
        RateLimiterRegistry limiterRegistry = RateLimiterRegistry.ofDefaults();
        RateLimiter limiter = limiterRegistry.rateLimiter("limiter");
        Runnable runnable = RateLimiter.decorateRunnable(limiter, () -> {
            long result = aLong.incrementAndGet();
            log.info("Result {}", result);
        });
        for (int i=0; i < 10000; i++){
            runnable.run();
        }
    }

    @Test
    void rateLimiterRegistryWithConfig() {
        RateLimiterRegistry limiterRegistry = RateLimiterRegistry.ofDefaults();
        RateLimiterConfig limiterConfig = RateLimiterConfig.custom()
                .limitForPeriod(250)
                .limitRefreshPeriod(Duration.ofSeconds(30))
                .timeoutDuration(Duration.ofSeconds(5)).build();
        limiterRegistry.addConfiguration("limiterConfig", limiterConfig);
        RateLimiter limiter = limiterRegistry.rateLimiter("limiter", "limiterConfig");
        Runnable runnable = RateLimiter.decorateRunnable(limiter, () -> {
            long result = aLong.incrementAndGet();
            log.info("Result {}", result);
        });
        for (int i=0; i < 10000; i++){
            runnable.run();
        }
    }

    @Test
    void testest() {
        log.info(String.valueOf(Runtime.getRuntime().availableProcessors()));
    }
}
