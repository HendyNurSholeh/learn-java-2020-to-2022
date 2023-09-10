package programmer.zaman.now.thread;

import org.junit.jupiter.api.Test;

import java.util.Random;
import java.util.concurrent.*;

public class CyclicBarrierTest {

    @Test
    void create() throws InterruptedException {
        var random = new Random();
        CyclicBarrier cyclicBarrier = new CyclicBarrier(3);
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        for (int i = 0; i < 100; i++) {
            final var temp = i + 1;
            executorService.execute(() -> {
                try {
                    System.out.println("Menunggu peserta ke " + temp);
                    cyclicBarrier.await();
                    System.out.println("start");
                    Thread.sleep(random.nextInt(5000));
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } catch (BrokenBarrierException e) {
                    throw new RuntimeException(e);
                }
            });
        }
        executorService.shutdown();
        executorService.awaitTermination(1, TimeUnit.HOURS);
    }
}
