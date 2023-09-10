package programmer.zaman.now.thread;

import org.junit.jupiter.api.Test;

import java.util.concurrent.*;

public class ExchangerTest {

    @Test
    void create() throws InterruptedException {
        final var exchanger = new Exchanger<String>();
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        executorService.execute(() -> {
            try {
                System.out.println("Thread 1 berjalan");
                String exchange = exchanger.exchange("data thread 1 nihh");

                System.out.println("Thread 1 = " + exchange);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        Thread.sleep(5000);
        executorService.execute(() -> {
            try {
                System.out.println("Thread 2 berjalan");
                String exchange = exchanger.exchange("data thread 2 nihh");
                System.out.println("Thread 2 = " + exchange);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        executorService.shutdown();
        executorService.awaitTermination(1, TimeUnit.HOURS);
    }
}
