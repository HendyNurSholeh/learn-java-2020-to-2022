package programmer.zaman.now.thread;

import org.junit.jupiter.api.Test;

public class ThreadCommunicationTest {

    private String message = null;

    @Test
    void manual() throws InterruptedException {
        var thread1 = new Thread(() -> {
            while (message == null){
                // wait
            }
            System.out.println(message);
        });

        var thread2 = new Thread(() -> {
            message = "hallo duniaaAAAA";
            System.out.println("thread 2 selesai");
        });

        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
    }

    @Test
    void waitNotify() throws InterruptedException {
        final Object lock = new Object();
        var thread1 = new Thread(() -> {
            synchronized (lock) {
                try {
                    lock.wait();
                    System.out.println(message);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        var thread2 = new Thread(() -> {
            synchronized (lock) {
                message = "hallo duniaaAAAA";
                System.out.println("thread 2 selesai");
                lock.notify();
            }
        });

        thread1.start();
        Thread.sleep(5000);
        thread2.start();
        thread1.join();
        thread2.join();
    }

    @Test
    void waitNotifyAll() throws InterruptedException {
        final Object lock = new Object();
        var thread1 = new Thread(() -> {
            synchronized (lock) {
                try {
                    lock.wait();
                    System.out.println("thread 1 : " + message);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        var thread2 = new Thread(() -> {
            synchronized (lock) {
                try {
                    lock.wait();
                    System.out.println("thread 2 : " + message);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        var thread3 = new Thread(() -> {
            synchronized (lock) {
                message = "hallo duniaaAAAA";
                lock.notifyAll();
            }
        });

        thread1.start();
        thread2.start();
        thread3.start();
//        Thread.sleep(5000);

        thread1.join();
        thread2.join();
        thread3.join();
    }
}
