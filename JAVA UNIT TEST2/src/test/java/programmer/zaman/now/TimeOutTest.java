package programmer.zaman.now;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.util.concurrent.TimeUnit;

public class TimeOutTest {

    @Test
    @Timeout(value = 5, unit = TimeUnit.SECONDS)
    void slow() throws InterruptedException{
        Thread.sleep(5001);
    }
}
