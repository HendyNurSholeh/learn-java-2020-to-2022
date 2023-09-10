package programmer.zaman.now.thread;

import org.junit.jupiter.api.Test;

import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class SemaphoreTest {

    @Test
    void create() throws InterruptedException {
        final var semaphore = new Semaphore(1);
        final var executors = Executors.newFixedThreadPool(10);

        for (int i = 0; i < 100; i++) {
            final var temp = i;
            executors.execute(() -> {
                try {
                    semaphore.acquire();
                    Thread.sleep(1000);
                    System.out.println("Task : " + temp);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }finally {
                    semaphore.release();
                }
            });
        }
        executors.shutdown();
        executors.awaitTermination(1, TimeUnit.HOURS);
    }
}
