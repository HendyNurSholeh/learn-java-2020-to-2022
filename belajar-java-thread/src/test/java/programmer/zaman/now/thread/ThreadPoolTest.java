package programmer.zaman.now.thread;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolTest {

    @Test
    void create() throws InterruptedException {

        var min = 10;
        var max = 100;
        var alive = 1;
        var aliveTime = TimeUnit.MINUTES;
        var queue = new ArrayBlockingQueue<Runnable>(100);

        var threadPool = new ThreadPoolExecutor(min, max, alive, aliveTime, queue);

        threadPool.execute(() -> {
            try {
                Thread.sleep(1000);
                System.out.println("hi thread : " + Thread.currentThread().getName());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        threadPool.execute(() -> {
            try {
                Thread.sleep(2000);
                System.out.println("hi thread : " + Thread.currentThread().getName());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        threadPool.execute(() -> {
            try {
                Thread.sleep(3000);
                System.out.println("hi thread : " + Thread.currentThread().getName());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        threadPool.execute(() -> {
            try {
                Thread.sleep(4000);
                System.out.println("hi thread : " + Thread.currentThread().getName());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        Thread.sleep(4000);
    }


    @Test
    void shutdown() throws InterruptedException {

        ArrayBlockingQueue<Runnable> queue = new ArrayBlockingQueue<>(100);
        LogRejectedExecutionHandler logRejectedExecutionHandler = new LogRejectedExecutionHandler();
        var threadPool = new ThreadPoolExecutor(
                10, 100, 1, TimeUnit.MINUTES, queue, logRejectedExecutionHandler);
        for (int i = 1; i <= 1000; i++) {
            final var task = i;
            Runnable runnable = () -> {
                try {
                    Thread.sleep(1000);
                    System.out.println("execute query ke " + task + " dari thread : " + Thread.currentThread().getName());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            };
            threadPool.execute(runnable);
        }


//        threadPool.shutdown();
        threadPool.awaitTermination(1, TimeUnit.DAYS);
//        Thread.sleep(5000);
    }

    public class LogRejectedExecutionHandler implements RejectedExecutionHandler {

        @Override
        public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
            System.out.println("Task : " + r + "is rejected");
        }
    }
}
