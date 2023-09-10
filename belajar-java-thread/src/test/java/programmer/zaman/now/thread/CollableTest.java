package programmer.zaman.now.thread;

import org.junit.jupiter.api.Test;

import java.net.HttpRetryException;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.*;
import java.util.function.IntFunction;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class CollableTest {

    @Test
    void create() throws ExecutionException, TimeoutException, InterruptedException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<String> future = executorService.submit(() -> {
            Thread.sleep(5000);
            return "Sudah selesai MANTAPPPP";
        });

//        while (!future.isDone()){
//            Thread.sleep(1000);
//            System.out.println("waiting result");
//        }
        Thread.sleep(3000);
        future.cancel(false);
        System.out.println(future.isCancelled());
        System.out.println(future.isDone());
    }

    @Test
    void invokeAll() throws InterruptedException, ExecutionException {
        ExecutorService executor = Executors.newFixedThreadPool(10);
        List<Callable<String>> callables = IntStream.range(1, 11).mapToObj(value -> (Callable<String>) () -> {
            Thread.sleep(value * 500L);
            return String.valueOf(value);
        }).collect(Collectors.toList());
        List<Future<String>> futures = executor.invokeAll(callables);
        for (var value : futures) {
            System.out.println(value.get());
        }
    }

    @Test
    void invokeAny() throws InterruptedException, ExecutionException {
        ExecutorService executor = Executors.newFixedThreadPool(10);
        List<Callable<String>> callables = IntStream.range(1, 11).mapToObj(value -> (Callable<String>) () -> {
            Thread.sleep(value * 500L);
            return String.valueOf(value);
        }).collect(Collectors.toList());
        String anys = executor.invokeAny(callables);
        System.out.println(anys);
    }
}
