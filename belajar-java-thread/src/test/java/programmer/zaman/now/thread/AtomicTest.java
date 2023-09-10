package programmer.zaman.now.thread;

import org.junit.jupiter.api.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class AtomicTest {

    private AtomicInteger  atomicInteger = new AtomicInteger();

    @Test
    void create() throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        for (int i = 0; i < 1000; i++) {
            final int task = i;
            executorService.execute(() -> {
                try {
                    Thread.sleep(100);
                    atomicInteger.addAndGet(1);
                    System.out.println(Thread.currentThread().getName());
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
        }
        Thread.sleep(15000);
        System.out.println(atomicInteger.get());
        executorService.shutdown();
        executorService.awaitTermination(1, TimeUnit.DAYS);
    }

    @Test
    void syncronizedCounter() throws InterruptedException{
        CounterAtomic counter = new CounterAtomic();
        Runnable runnable = () -> {
            for (int i = 1; i <= 1_000_000; i++) {
                counter.increment();
            }
        };

        var thread1 = new Thread(runnable);
        var thread2 = new Thread(runnable);
        var thread3 = new Thread(runnable);

        thread1.start();
        thread2.start();
        thread3.start();

        thread1.join();
        thread2.join();
        thread3.join();

        System.out.println(counter.getValue());
    }
}
