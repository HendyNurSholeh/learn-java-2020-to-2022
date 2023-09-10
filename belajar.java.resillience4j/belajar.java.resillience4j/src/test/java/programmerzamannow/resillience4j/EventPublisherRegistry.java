package programmerzamannow.resillience4j;

import io.github.resilience4j.ratelimiter.RateLimiterRegistry;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class EventPublisherRegistry {

    @Test
    void createEventPublisher() {
        RateLimiterRegistry limiterRegistry = RateLimiterRegistry.ofDefaults();
        limiterRegistry.getEventPublisher().onEntryAdded(event ->
                log.info("Added : {}", event.getAddedEntry().getName()));
        limiterRegistry.rateLimiter("hyns");
        limiterRegistry.rateLimiter("hyns");
        limiterRegistry.rateLimiter("hyns2");
    }
}
