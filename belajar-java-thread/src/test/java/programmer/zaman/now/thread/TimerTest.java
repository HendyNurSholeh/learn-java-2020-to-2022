package programmer.zaman.now.thread;

import org.junit.jupiter.api.Test;

import java.sql.Time;
import java.time.Instant;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicInteger;

public class TimerTest {

    @Test
    void delayedJob() throws InterruptedException {
        AtomicInteger second = new AtomicInteger();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                System.out.println("tunggu selama : " + second.addAndGet(1));
            }
        };

        var timer = new Timer();
        timer.schedule(task, Date.from(Instant.now().plusSeconds(3)), 1000);
        Thread.sleep(15000);
    }
}
