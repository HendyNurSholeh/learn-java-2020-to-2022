package programmer.zaman.now.thread;

import org.junit.jupiter.api.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class LockTest {

    @Test
    void counterLock() throws InterruptedException {
        CounterLock counterLock = new CounterLock();
        ExecutorService executors = Executors.newFixedThreadPool(10);

        for (int i = 0; i < 1000; i++) {
            executors.execute(() -> {
                try {
                    Thread.sleep(100);
                    counterLock.increment();
                    System.out.println(counterLock.getValue());
                    System.out.println(Thread.currentThread().getName());
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
        }

        executors.shutdown();
        executors.awaitTermination(1, TimeUnit.HOURS);
    }

    @Test
    void counterLock2() throws InterruptedException {
        CounterLock counter = new CounterLock();
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

    @Test
    void counterReadWriteLock() throws InterruptedException {
        CounterReadWriteLock counter = new CounterReadWriteLock();
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

    @Test
    void ConditionTest() throws InterruptedException {
        AtomicInteger number = new AtomicInteger();
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        var lock = new ReentrantLock();
        var condition = lock.newCondition();

        executorService.execute(() -> {
            try {
                lock.lock();
                condition.await();
                System.out.println(number.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        });

        executorService.execute(() -> {
            try {
                lock.lock();
                condition.await();
                System.out.println(number.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        });

        executorService.execute(() -> {
            try {
                lock.lock();
                number.set(10);
                condition.signalAll();
            } finally {
                lock.unlock();
            }
        });
        executorService.shutdown();
        executorService.awaitTermination(1, TimeUnit.HOURS);
    }
}
