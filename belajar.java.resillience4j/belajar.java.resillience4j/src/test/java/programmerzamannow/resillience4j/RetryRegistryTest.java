package programmerzamannow.resillience4j;

import com.sun.net.httpserver.Authenticator;
import io.github.resilience4j.retry.Retry;
import io.github.resilience4j.retry.RetryConfig;
import io.github.resilience4j.retry.RetryRegistry;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.util.Scanner;

@Slf4j
public class RetryRegistryTest {

    void task(){
        log.info("task is running");
        throw new RuntimeException();
    }


    @Test
    void createRetryRegistry() {
        RetryRegistry retryRegistry = RetryRegistry.ofDefaults();
        Retry retry = retryRegistry.retry("hyns");
        Retry retry2 = retryRegistry.retry("hyns");
        Runnable runnable = Retry.decorateRunnable(retry, () -> task());
        Assertions.assertSame(retry, retry2);
        runnable.run();
    }

    @Test
    void createRetryRegistryWithConfig() {
        RetryRegistry retryRegistry = RetryRegistry.ofDefaults();
        RetryConfig config = RetryConfig.custom()
                .maxAttempts(5)
                .waitDuration(Duration.ofMillis(0))
                .retryExceptions(RuntimeException.class).build();
        Retry retry1 = retryRegistry.retry("hyns", config);
        Retry retry2 = retryRegistry.retry("hyns");
        Retry retry3 = retryRegistry.retry("hyns1");
        Runnable runnable1 = Retry.decorateRunnable(retry1, () -> task());
        Runnable runnable2 = Retry.decorateRunnable(retry2, () -> task());
        Runnable runnable3 = Retry.decorateRunnable(retry3, () -> task());
        Assertions.assertSame(retry1, retry2);
        log.info(retry1.toString());
        log.info(retry2.toString());
        Assertions.assertNotSame(retry1, retry3);
        runnable3.run();
    }
}
