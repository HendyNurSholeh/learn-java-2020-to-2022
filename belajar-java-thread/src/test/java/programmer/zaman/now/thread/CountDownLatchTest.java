package programmer.zaman.now.thread;

import org.junit.jupiter.api.Test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class CountDownLatchTest {

    @Test
    void create() throws InterruptedException {
        var countDownLate = new CountDownLatch(3);
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        for (int i = 0; i < 3; i++) {
            final var temp = i + 1;
            executorService.execute(() -> {
                try {
                    System.out.println("sedang menyelesaikan tugas ke " + temp + "...");
                    System.out.println("telah menyelesaikan tugas ke " + temp);
                } finally {
                    countDownLate.countDown();
                }
            });
        }
        executorService.execute(() -> {
            try {
                Thread.sleep(2000);
                System.out.println("Menunggu tugas 1,2,3 selesai");
                countDownLate.await();
                System.out.println("PROGRAM SUKSES");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread.sleep(3000);
        System.out.println(countDownLate.getCount());

        executorService.shutdown();
        executorService.awaitTermination(1, TimeUnit.HOURS);
    }
}
