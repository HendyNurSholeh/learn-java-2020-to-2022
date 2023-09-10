package programmer.zaman.now.thread;

import org.junit.jupiter.api.Test;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class ParallelStreamTest {

    @Test
    void create() {
        int sum = IntStream.range(0, 3000).parallel()
                .peek(value -> System.out.println(Thread.currentThread().getName() + " : " + value))
                .sum();
        System.out.println(sum);
    }

    @Test
    void membatasiThread() throws InterruptedException {
        ForkJoinPool forkJoinPool = new ForkJoinPool(2);
        forkJoinPool.execute(() -> {
            int sum = IntStream.range(0, 3000).parallel()
                    .peek(value -> System.out.println(Thread.currentThread().getName() + " : " + value))
                    .sum();
            System.out.println(sum);
        });
        forkJoinPool.shutdown();
        forkJoinPool.awaitTermination(1, TimeUnit.HOURS);
    }
}
