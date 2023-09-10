package programmer.zaman.now.thread;

import org.junit.jupiter.api.Test;

import java.util.Random;
import java.util.concurrent.*;

public class CompletableFutureTest {

    private ExecutorService executorService = Executors.newFixedThreadPool(10);
    private Random random = new Random();
    public  CompletableFuture<Integer> getValue(){
        CompletableFuture<Integer> completableFuture = new CompletableFuture();
        executorService.execute(() -> {
            try {
                Thread.sleep(5000);
                throw new InterruptedException();
//                completableFuture.complete("Bajak laut Raja luffy");
//                completableFuture.complete(2468);
            } catch (InterruptedException e) {
                System.out.println("masuk sini");
                completableFuture.completeExceptionally(e);
            }
        });
        return completableFuture;
    }

    public void execute(CompletableFuture<String> future, String value){
        executorService.execute(() -> {
            try {
                Thread.sleep(1000 + random.nextInt(5000));
                future.complete(value);
            }catch (InterruptedException e){
                future.completeExceptionally(e);
            }
        });
    }

    public Future<String> getFasTest(){
        CompletableFuture<String> future = new CompletableFuture<>();

        execute(future, "thread 1");
        execute(future, "thread 2");

        return future;
    }

    @Test
    void create() throws ExecutionException, InterruptedException {
//        CompletableFuture<Integer> value = getValue();
//        value.get();
//        value.cancel(true);
//        Integer integer = value.get();
//        System.out.println(integer);
        CompletableFuture<String> future = new CompletableFuture<>();
        CompletableFuture<String> future2 = new CompletableFuture<>();
        CompletableFuture<String> future3 = new CompletableFuture<>();
        CompletableFuture<String> future4 = new CompletableFuture<>();
        execute( future, "hai1");
        execute( future2, "hai2");
        execute( future3, "hai3");
        execute( future4, "hai4");

        System.out.println(future.get());
        System.out.println(future2.get());
        System.out.println(future3.get());
        System.out.println(future4.get());
        executorService.shutdown();
        executorService.awaitTermination(10, TimeUnit.SECONDS);
    }

    @Test
    void TestFasTest() throws ExecutionException, InterruptedException {
        Future<String> fasTest = getFasTest();
        Thread.sleep(7000);
        System.out.println(fasTest.get());
    }

    @Test
    void completionStage() throws ExecutionException, InterruptedException {
        CompletableFuture<String> future = getValue().thenApply(Object::toString).thenApply(value -> "your number is " + value);
        System.out.println("sedang menunggu");
        System.out.println(future.get());
    }
}
