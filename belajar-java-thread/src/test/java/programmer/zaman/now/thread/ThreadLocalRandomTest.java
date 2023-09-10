package programmer.zaman.now.thread;

import org.junit.jupiter.api.Test;

import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class ThreadLocalRandomTest {

    @Test
    void create() throws InterruptedException {
        var executor = Executors.newFixedThreadPool(10);

        for (int i = 0; i < 100; i++) {
            executor.execute(() -> {
                try {
                    Thread.sleep(1000);
                    int number = ThreadLocalRandom.current().nextInt(100);
                    System.out.println(number);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
        }
        executor.shutdown();
        executor.awaitTermination(1, TimeUnit.HOURS);
    }

    @Test
    void create2() throws InterruptedException {
        final var executor = Executors.newFixedThreadPool(10);
        final UserService userService = new UserService();

        for (int i = 0; i < 100; i++) {
            var index = i + 1;
            executor.execute(() -> {
                try {
                    userService.setThreadLocal(Thread.currentThread().getName() + " : user " + index);
                    Thread.sleep(1000 + ThreadLocalRandom.current().nextInt(3000));
                    System.out.println(Thread.currentThread().getName() + " get : " + userService.doAction());
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
        }
        executor.shutdown();
        executor.awaitTermination(1, TimeUnit.HOURS);
    }

    @Test
    void threadPoolRandom() throws InterruptedException {
        var executor = Executors.newFixedThreadPool(10);

        for (int i = 0; i < 10; i++) {
            executor.execute(() -> {
                try {
                    Thread.sleep(1000);
                    ThreadLocalRandom.current().ints(10, 0, 100)
                            .mapToObj(value -> "number : " + value).forEach(System.out::println);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
        }
        executor.shutdown();
        executor.awaitTermination(1, TimeUnit.HOURS);
    }
}
