package programmer.zaman.now.thread;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class ForkJoinPoolTest {

    @Test
    void create() {
        ForkJoinPool forkJoinPool = ForkJoinPool.commonPool();
        ForkJoinPool forkJoinPool1 = new ForkJoinPool(2);

        ExecutorService executorService1 = Executors.newWorkStealingPool(2);
        ExecutorService executorService = Executors.newWorkStealingPool();
    }

    @Test
    void simpleForkJoinTaskTest() throws InterruptedException {
        var forkJoinPool = ForkJoinPool.commonPool();
        var numbers = IntStream.range(0, 1000).boxed().collect(Collectors.toList());
        SimpleForkJoinTask simpleForkJoinTask = new SimpleForkJoinTask(numbers);
        forkJoinPool.execute(simpleForkJoinTask);

        forkJoinPool.shutdown();
        forkJoinPool.awaitTermination(1, TimeUnit.DAYS);
    }

    @Test
    void TotalForkJoinTaskTest() throws InterruptedException {
        var forkJoinPool = ForkJoinPool.commonPool();
        var numbers = IntStream.range(0, 1000).boxed().collect(Collectors.toList());
        var totalForkJoinTask = new TotalForkJoinTask(numbers);
        ForkJoinTask<Long> submit = forkJoinPool.submit(totalForkJoinTask);
        Long data = submit.join();
        System.out.println(data);

        forkJoinPool.shutdown();
        forkJoinPool.awaitTermination(1, TimeUnit.DAYS);
    }

    public static class TotalForkJoinTask extends RecursiveTask<Long> {

        private List<Integer> numbers;

        public TotalForkJoinTask(List<Integer> numbers) {
            this.numbers = numbers;
        }

        @Override
        protected Long compute() {
            if(numbers.size() <= 10) {
                return doCompute();
            } else {
                return forkCompute();
            }
        }

        public Long doCompute() {
            System.out.println("----- It is doCompute -----");
            return numbers.stream().mapToLong(value -> value)
                    .peek(value -> System.out.println(Thread.currentThread().getName() + " : " + value))
                    .sum();
        }

        private Long forkCompute() {
            System.out.println("----- It is forkCompute -----");
            var list1 = numbers.subList(0, numbers.size() / 2);
            var list2 = numbers.subList(numbers.size() / 2, numbers.size());

            TotalForkJoinTask simpleForkJoin1 = new TotalForkJoinTask(list1);
            TotalForkJoinTask simpleForkJoin2 = new TotalForkJoinTask(list2);

            ForkJoinTask.invokeAll(simpleForkJoin1, simpleForkJoin2);
            return simpleForkJoin1.join() + simpleForkJoin2.join();
        }
    }

    public static class SimpleForkJoinTask extends RecursiveAction {

        private List<Integer> numbers;

        public SimpleForkJoinTask(List<Integer> numbers) {
            this.numbers = numbers;
        }

        @Override
        protected void compute() {
            if(numbers.size() <= 10) {
                doCompute();
            } else {
                forkCompute();
            }
        }

        public void doCompute() {
            System.out.println("----- It is doCompute -----");
            var result = numbers;
            result.forEach(value -> System.out.println(Thread.currentThread().getName() + " : " + value));
        }

        public void forkCompute() {
            System.out.println("----- It is forkCompute -----");
            var list1 = numbers.subList(0, numbers.size() / 2);
            var simpleForkJoin1 = new SimpleForkJoinTask(list1);
            var list2 = numbers.subList(numbers.size() / 2, numbers.size());
            var simpleForkJoin2 = new SimpleForkJoinTask(list2);

            ForkJoinTask.invokeAll(simpleForkJoin1, simpleForkJoin2);
        }
    }
}
