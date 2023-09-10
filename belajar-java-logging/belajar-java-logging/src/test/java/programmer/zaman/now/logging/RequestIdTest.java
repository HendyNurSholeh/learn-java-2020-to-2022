package programmer.zaman.now.logging;

import org.junit.jupiter.api.Test;
import org.slf4j.MDC;

import java.util.Random;
import java.util.UUID;

public class RequestIdTest {

    @Test
    void testRequestId() throws InterruptedException {
        var controller = new MyController(new MyService(new MyRepository()));

        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                String id = UUID.randomUUID().toString();
                MDC.put("requestId", id);
                controller.save();
                MDC.remove("requestId");
            }).start();
        }

        Thread.sleep(1000);
    }
}
