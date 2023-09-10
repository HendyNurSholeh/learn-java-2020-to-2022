package programmer.zaman.now.thread;

import org.junit.jupiter.api.Test;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Phaser;
import java.util.concurrent.TimeUnit;

public class PhaserTest {

    @Test
    void countDownLatch() throws InterruptedException {
        Phaser phaser = new Phaser();
        Random random = new Random();
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        phaser.bulkRegister(5);

        executorService.execute(() -> {
            System.out.println("menunggu 5 tugas selesai");
            phaser.awaitAdvance(1);
            System.out.println("MISSION COOMPLED");
        });

        for (int i = 0; i < 4; i++) {
            var temp = i + 1;
            executorService.execute(() -> {
                try {
                    Thread.sleep(random.nextInt(10000));
                    System.out.println("Thread " + temp + " Ends");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }finally {
                    phaser.arrive();
                }
            });
        }
//        executorService.shutdown();
        executorService.awaitTermination(1, TimeUnit.HOURS);
    }

    @Test
    void cyclicBarrier() throws InterruptedException {
        var phaser = new Phaser();
        var random = new Random();
        var executor = Executors.newFixedThreadPool(10);

        phaser.bulkRegister(5);
        System.out.println("Menunggu 5 thread siap..");
        for (int i = 0; i < 5; i++) {
            var temp = i + 1;
            executor.execute(() -> {
                try {
                    Thread.sleep(random.nextInt(10000));
                    System.out.println("Thread " + temp + " siap boss");
                    phaser.arriveAndAwaitAdvance();
                    System.out.println("Gasskeunn");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
        }
        executor.shutdown();
        executor.awaitTermination(1, TimeUnit.HOURS);
    }
}
