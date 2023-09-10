package programmer.zaman.now.thread;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.*;

public class BlockingQueueTest {

    @Test
    void arrayBlockingQueue() throws InterruptedException {
        var arrayQueue = new ArrayBlockingQueue<String>(5);
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 6; i++) {
            final var temp = i + 1;
            executorService.execute(() -> {
                try {
                    arrayQueue.put("input ke " + temp);
                    System.out.println("Sukses menambah data ke " + temp);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
        }
        executorService.shutdown();
        executorService.awaitTermination(1, TimeUnit.HOURS);
        System.out.println(arrayQueue.size());
        arrayQueue.forEach(System.out::println);
    }

    @Test
    void linkedBlockingQueue() throws InterruptedException {
        var arrayQueue = new LinkedBlockingQueue<String>();
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 30; i++) {
            final var temp = i + 1;
            executorService.execute(() -> {
                try {
                    arrayQueue.put("input ke " + temp);
                    System.out.println("Sukses menambah data ke " + temp);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
        }
        executorService.shutdown();
        executorService.awaitTermination(1, TimeUnit.HOURS);
        System.out.println(arrayQueue.size());
        arrayQueue.forEach(System.out::println);
    }

    @Test
    void priorityBlockingQueue() throws InterruptedException {
        var priorityQueue = new PriorityBlockingQueue<Integer>(10);
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 30; i++) {
            final var temp = i + 1;
            executorService.execute(() -> {
                priorityQueue.put(temp);
            });
        }
        executorService.shutdown();
        executorService.awaitTermination(1, TimeUnit.HOURS);
        System.out.println("size = " + priorityQueue.size());
        while (true) {
            System.out.println(priorityQueue.take());
            if (priorityQueue.isEmpty()){
                break;
            }
        }
    }

    @Test
    void delayQueue() throws InterruptedException, ExecutionException {
        var delayQueues = new DelayQueue<ScheduledFuture<String>>();
        var executorService = Executors.newScheduledThreadPool(10);
        for (int i = 0; i < 30; i++) {
            var temp = i + 1;
            delayQueues.put(executorService.schedule(() -> "delay ke " + temp, temp, TimeUnit.SECONDS));
        }
        while (true) {
            System.out.println(delayQueues.take().get());
            if (delayQueues.isEmpty()){
                break;
            }
        }
    }

    @Test
    void synchoronousQueue() throws InterruptedException {
        var queue = new SynchronousQueue<String>();
        var executors = Executors.newFixedThreadPool(10);

        for (int i = 0; i < 10; i++) {
            var temp = i + 1;
            executors.execute(() -> {
                try {
                    queue.put("data ke" + temp);
                    System.out.println("sukses menambah data ke " + temp);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
        }

        for (int i = 0; i < 10; i++) {
            Thread.sleep(1000);
            System.out.println("sukses mengambil data " + queue.take());
        }
        System.out.println("sampai sini");
        executors.shutdown();
        executors.awaitTermination(1, TimeUnit.HOURS);
    }

    @Test
    void blockingDeque() throws InterruptedException {
        var deque = new LinkedBlockingDeque<Integer>();
        var executor = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 10; i++) {
            deque.put(i);
        }
        for (int i = 0; i < 10; i++) {
            Thread.sleep(500);
            executor.execute(() -> {
                try {
                    System.out.println("suskes mengambil data " + deque.takeLast());
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
        }
        System.out.println(deque.size());
        executor.shutdown();
        executor.awaitTermination(1, TimeUnit.HOURS);
    }

    @Test
    void transferQueue() throws InterruptedException {
        var queue = new LinkedTransferQueue<String>();
        var executors = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 10; i++) {
            var temp = i + 1;
            executors.execute(() -> {
                try {
                    queue.transfer("data ke" + temp);
                    System.out.println("sukses menambah data ke " + temp);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
        }
        for (int i = 0; i < 10; i++) {
            Thread.sleep(1000);
            System.out.println("sukses mengambil data " + queue.take());
        }
        executors.shutdown();
        executors.awaitTermination(1, TimeUnit.HOURS);
    }

    @Test
    void concurrentMap() throws InterruptedException {
        var countDownLatch = new CountDownLatch(100);
        var concurrentMap = new ConcurrentHashMap<Integer, String>();
        var executors = Executors.newFixedThreadPool(100);

        for (int i = 0; i < 100; i++) {
            final var temp = i + 1;
            executors.execute(() -> {
                try {
                    Thread.sleep(1000);
                    concurrentMap.putIfAbsent(temp, "Data ke " + temp);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } finally {
                    countDownLatch.countDown();
                }
            });
        }
        countDownLatch.await();
        concurrentMap.forEach((integer, s) -> System.out.println(integer + " : " + s));
        executors.shutdown();
        executors.awaitTermination(1, TimeUnit.HOURS);
    }

    @Test
    void convertCollection() {
        var list = List.of("hendy", "nur", "sholeh");
        var listThreadSave = Collections.synchronizedList(list);

    }
}
