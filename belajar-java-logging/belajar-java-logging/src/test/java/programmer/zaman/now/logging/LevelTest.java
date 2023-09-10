package programmer.zaman.now.logging;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LevelTest {

    private static final Logger log = LoggerFactory.getLogger(LevelTest.class);

    @Test
    void testLevel() {
        log.trace("Level Trace");
        log.debug("Level Debug");
        log.info("Level Info");
        log.warn("Level Warning");
        log.error("Level Error");
    }
}
