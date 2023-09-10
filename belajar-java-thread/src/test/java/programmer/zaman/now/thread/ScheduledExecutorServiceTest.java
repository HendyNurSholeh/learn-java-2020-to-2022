package programmer.zaman.now.thread;

import org.junit.jupiter.api.Test;

import java.util.concurrent.*;

public class ScheduledExecutorServiceTest {

    @Test
    void create() throws InterruptedException, ExecutionException {
        ScheduledExecutorService scheduledExecutor = Executors.newSingleThreadScheduledExecutor();
        ScheduledFuture<String> schedule = scheduledExecutor.
                schedule(() -> "sedang menunggu", 3, TimeUnit.SECONDS);
        System.out.println(schedule.getDelay(TimeUnit.SECONDS));
        schedule.get();
        Thread.sleep(5000);
        scheduledExecutor.shutdown();
        scheduledExecutor.awaitTermination(1, TimeUnit.DAYS);
    }
}
