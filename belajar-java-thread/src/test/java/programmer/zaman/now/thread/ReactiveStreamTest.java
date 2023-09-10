package programmer.zaman.now.thread;

import org.junit.jupiter.api.Test;

import java.util.concurrent.*;

public class ReactiveStreamTest {

    @Test
    void publisher() throws InterruptedException {
        var executor = Executors.newFixedThreadPool(10);
        var publisher = new SubmissionPublisher<String>();
        var printSubscriber1 = new PrintSubscriber("Subcrib A", 1000L);
        var printSubscriber2 = new PrintSubscriber("Subcrib b", 400L);

        publisher.subscribe(printSubscriber1);
        publisher.subscribe(printSubscriber2);

        executor.execute(() -> {
            for (int i = 0; i < 100; i++) {
                final var temp = i + 1;
                try {
                    Thread.sleep(2000);
                    publisher.submit("hendy ke " + temp);
                    System.out.println(Thread.currentThread().getName() + ": Send hendy " + temp);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        executor.shutdown();
        executor.awaitTermination(1, TimeUnit.DAYS);
        Thread.sleep(10000);
    }

    @Test
    void buffer() throws InterruptedException {
        var executor = Executors.newFixedThreadPool(10);
        var publisher = new SubmissionPublisher<String>(Executors.newWorkStealingPool(), 10);
        var printSubscriber1 = new PrintSubscriber("Subcrib A", 1000L);
        var printSubscriber2 = new PrintSubscriber("Subcrib b", 400L);

        publisher.subscribe(printSubscriber1);
        publisher.subscribe(printSubscriber2);

        executor.execute(() -> {
            for (int i = 0; i < 100; i++) {
                final var temp = i + 1;
//                try {
//                    Thread.sleep(2000);
                    publisher.submit("hendy ke " + temp);
                    System.out.println(Thread.currentThread().getName() + ": Send hendy " + temp);
//                } catch (InterruptedException e) {
//                    throw new RuntimeException(e);
//                }
            }
        });

        executor.shutdown();
        executor.awaitTermination(1, TimeUnit.DAYS);
        Thread.sleep(1000000);
    }

    @Test
    void Processor() throws InterruptedException {
        var executor = Executors.newWorkStealingPool();

        var publisher = new SubmissionPublisher<String>();

        var helloProcessor = new HelloProcessor();
        publisher.subscribe(helloProcessor);

        var printSubscriber1 = new PrintSubscriber("Subcrib A", 1000L);
        helloProcessor.subscribe(printSubscriber1);

        executor.execute(() -> {
            for (int i = 0; i < 100; i++) {
                final var temp = i + 1;
                publisher.submit("hendy ke " + temp);
                System.out.println(Thread.currentThread().getName() + ": Send hendy " + temp);
            }
        });

        executor.shutdown();
        executor.awaitTermination(1, TimeUnit.DAYS);
        Thread.sleep(100000);
    }

    public static class PrintSubscriber implements Flow.Subscriber<String>{

        private Flow.Subscription subscription;
        private String name;

        private Long sleep;

        public PrintSubscriber(String name, Long sleep) {
            this.name = name;
            this.sleep = sleep;
        }

        @Override
        public void onSubscribe(Flow.Subscription subscription) {
            this.subscription = subscription;
            this.subscription.request(1);
        }

        @Override
        public void onNext(String item) {
            try {
                Thread.sleep(sleep);
                System.out.println(Thread.currentThread().getName() + ": " + name + " : " + item);
                subscription.request(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

        @Override
        public void onError(Throwable throwable) {
            throwable.printStackTrace();
        }

        @Override
        public void onComplete() {
            System.out.println(Thread.currentThread().getName() + " : COMPLED BROOO");
        }
    }

    public static class HelloProcessor extends SubmissionPublisher<String>
            implements Flow.Processor<String, String>{

        private Flow.Subscription subscription;

        @Override
        public void onSubscribe(Flow.Subscription subscription) {
            this.subscription = subscription;
            this.subscription.request(1);
        }

        @Override
        public void onNext(String item) {
            var value = "Hai " + item;
            submit(value);
            this.subscription.request(1);
        }

        @Override
        public void onError(Throwable throwable) {
            throwable.printStackTrace();
        }

        @Override
        public void onComplete() {
            close();
        }
    }
}
