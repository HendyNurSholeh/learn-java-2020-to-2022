package programmer.zaman.now.thread;

import org.junit.jupiter.api.Test;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ThreadLocalTest {

    @Test
    void create() throws InterruptedException {
        final var executor = Executors.newFixedThreadPool(10);
        var cownDown = new CountDownLatch(1);
        UserService userService = new UserService();


        executor.execute(() -> {
            try {
                Thread.sleep(2000);
                userService.setThreadLocal("hendy");
                System.out.println("success set ThreadLocal");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally {
                cownDown.countDown();
            }
        });

        executor.execute(() -> {
            try {
                cownDown.await();
                System.out.println("try take data");
                userService.doAction();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        executor.shutdown();
        executor.awaitTermination(1, TimeUnit.HOURS);
    }

    @Test
    void create2() throws InterruptedException {
        final var executor = Executors.newFixedThreadPool(10);
        final var random = new Random();
        final UserService userService = new UserService();

        for (int i = 0; i < 100; i++) {
            var index = i + 1;
            executor.execute(() -> {
                try {
                    userService.setThreadLocal(Thread.currentThread().getName() + " : user " + index);
                    Thread.sleep(1000 + random.nextInt(3000));
                    System.out.println(Thread.currentThread().getName() + " get : " + userService.doAction());
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
        }
        executor.shutdown();
        executor.awaitTermination(1, TimeUnit.HOURS);
    }
}
