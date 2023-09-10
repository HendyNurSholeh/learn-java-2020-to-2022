package programmerzamannow.resillience4j;

import io.github.resilience4j.retry.Retry;
import io.github.resilience4j.retry.RetryConfig;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.time.Duration;

@Slf4j
public class RetryConfigTest {

    void task() {
      log.info("Execute task");
      throw new IllegalArgumentException("ahha erorr");
    }

    @Test
    void createNewRetryConfig() {
        var retryConfig = RetryConfig.custom().maxAttempts(5).build();
        var retry = Retry.of("hyns", retryConfig);
        var runnable = Retry.decorateRunnable(retry, () -> task());
        runnable.run();
    }


}
