package programmer.zaman.now.thread;

import org.junit.jupiter.api.Test;
import org.springframework.scheduling.config.Task;

import java.awt.font.TextHitInfo;
import java.util.Random;
import java.util.concurrent.*;

public class ComplationServiceTest {

    private Random random = new Random();

    @Test
    void create() throws InterruptedException, ExecutionException {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        ExecutorCompletionService<String> completionService = new ExecutorCompletionService<>(executorService);

        ExecutorService executorService2 = Executors.newFixedThreadPool(10);

        // eksekusi
        executorService2.execute(() -> {

                completionService.submit(() -> {
                    Thread.sleep(10000);
                    return "Task selesai";
                });
//            for (int i = 0; i < 100; i++) {
//                final var number = i;
//            }
        });

        // menunggu

        executorService2.execute(() -> {
            try {
                Future<String> future = completionService.poll(1, TimeUnit.SECONDS);
                if (future == null){
                    System.out.println("future null");
                }
                System.out.println(future.get());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        });

        executorService2.shutdown();
        executorService2.awaitTermination(1, TimeUnit.HOURS);
    }
}
