package programmerzamannow.resillience4j;

import io.github.resilience4j.circuitbreaker.CircuitBreaker;
import io.github.resilience4j.circuitbreaker.CircuitBreakerConfig;
import io.github.resilience4j.circuitbreaker.CircuitBreakerRegistry;
import io.vavr.CheckedRunnable;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.util.concurrent.atomic.AtomicLong;

@Slf4j
public class CircuitBreakerTest {

    private AtomicLong counter = new AtomicLong(0L);

    void callSystem(){
        log.info("Running call : " + counter.incrementAndGet());
        throw new RuntimeException();
    }

    @Test
    @SneakyThrows
    void createCircuitBreaker() {
        CircuitBreaker circuitBreaker = CircuitBreaker.ofDefaults("hyns");
        Runnable runnable = CircuitBreaker.decorateRunnable(circuitBreaker, () -> callSystem());
        for (int i = 0; i < 120; i++) {
            try{
                runnable.run();
            } catch (Exception e){
                log.info(e.getMessage());
            }
        }
    }

    @Test
    @SneakyThrows
    void circuitBreakerWithConfig() {
        CircuitBreakerConfig config = CircuitBreakerConfig.custom()
                .slidingWindowType(CircuitBreakerConfig.SlidingWindowType.COUNT_BASED)
                .failureRateThreshold(30)
                .slidingWindowSize(12)
                .minimumNumberOfCalls(12)
                .waitDurationInOpenState(Duration.ofSeconds(10))
                .build();
        CircuitBreaker circuitBreaker = CircuitBreaker.of("hyns", config);
        Runnable runnable = CircuitBreaker.decorateRunnable(circuitBreaker, () -> callSystem());
        for (int i = 0; i < 100; i++) {
            try{
                Thread.sleep(500);
                runnable.run();
            } catch (Exception e){
                log.info(e.getMessage());
            }
        }
        Thread.sleep(50000);
    }

    @Test
    @SneakyThrows
    void circuitBreakerRegistryWithConfig() {
        CircuitBreakerRegistry circuitBreakerRegistry = CircuitBreakerRegistry.ofDefaults();
        CircuitBreakerConfig config = CircuitBreakerConfig.custom()
                .slidingWindowType(CircuitBreakerConfig.SlidingWindowType.COUNT_BASED)
                .slidingWindowSize(20)
                .minimumNumberOfCalls(20)
                .failureRateThreshold(20)
                .waitDurationInOpenState(Duration.ofSeconds(10))
                .build();
        circuitBreakerRegistry.addConfiguration("config", config);
        CircuitBreaker circuitBreaker = circuitBreakerRegistry.circuitBreaker("hyns", "config");
        CircuitBreaker circuitBreaker1 = circuitBreakerRegistry.circuitBreaker("hyns");
        Assertions.assertSame(circuitBreaker1, circuitBreaker);
        Runnable runnable = CircuitBreaker.decorateRunnable(circuitBreaker, () -> callSystem());
        for (int i = 0; i < 100; i++) {
            Thread.sleep(500);
            try {
                runnable.run();
            } catch (Exception e){
                log.info(e.getMessage());
            }
        }
        Thread.sleep(30000);
    }
}
