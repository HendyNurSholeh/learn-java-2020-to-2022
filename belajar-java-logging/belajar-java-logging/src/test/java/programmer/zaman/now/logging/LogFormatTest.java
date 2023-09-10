package programmer.zaman.now.logging;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogFormatTest {

    private static final Logger log = LoggerFactory.getLogger(LogFormatTest.class);

    @Test
    void testLogFormat() {

        String data = "hendy";
        log.info("without parameter");
        log.info("hello {}", data, data);
        log.info("hello {}");
        log.info("eror", new NullPointerException());
        log.error("eror", new NullPointerException());
    }
}
