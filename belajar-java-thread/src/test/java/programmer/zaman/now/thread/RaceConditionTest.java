package programmer.zaman.now.thread;

import org.junit.jupiter.api.Test;

import java.util.concurrent.atomic.AtomicInteger;

public class RaceConditionTest {

    @Test
    void counter() throws InterruptedException {
        Counter counter = new Counter();
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
