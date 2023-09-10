package programmer.zaman.now.thread;

import org.junit.jupiter.api.Test;

public class ThreadTest {

    @Test
    void mainThread() {
        System.out.println(Thread.currentThread().getName());
    }

    @Test
    void createThread() {
        Runnable runnable = () -> System.out.println("Hello from Thread : " + Thread.currentThread().getName());
        runnable.run();
        var thread = new Thread(runnable);
        thread.start();
        System.out.println("Program selesai!!");
    }

    @Test
    void threadSleep() {
        Runnable runnable = () -> {
            try {
                Thread.sleep(1000);
                System.out.println("Hello from Thread : " + Thread.currentThread().getName());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        };
        runnable.run();
        var thread = new Thread(runnable);
        thread.start();
        System.out.println("Program selesai!!");
    }

    @Test
    void threadJoin() throws InterruptedException {
        Runnable runnable = () -> {
            try {
                Thread.sleep(1000);
                System.out.println("Hello from Thread : " + Thread.currentThread().getName());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        };
        runnable.run();
        var thread = new Thread(runnable);
        thread.start();
        System.out.println("Program selesai!!");
        thread.join();
    }

    @Test
    void threadInteruptWrong() throws InterruptedException {
        Runnable runnable = () -> {
            for (int i = 0; i < 10; i++) {
                System.out.println("Runnable : " + i);
                try {
                    Thread.sleep(1000);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        };
        Thread thread = new Thread(runnable);
        thread.start();
        Thread.sleep(5000);
        thread.interrupt();
        System.out.println("Menunggu Selesai");
        thread.join();
        System.out.println("Program Selesai");
    }

    @Test
    void threadInteruptCorrect() throws InterruptedException {
        Runnable runnable = () -> {
            for (int i = 0; i < 10; i++) {
                if (Thread.interrupted()){
                    return;
                }
                System.out.println("Runnable : " + i);
            }
        };
        Thread thread = new Thread(runnable);
        thread.start();
        Thread.sleep(7);
        thread.interrupt();
        System.out.println("Menunggu Selesai");
        thread.join();
        System.out.println("Program Selesai");
    }

    @Test
    void threadName() throws InterruptedException {
        Runnable runnable = () -> {
            for (int i = 1; true ; i++) {
                try {
                    Thread.sleep(1000);
                    System.out.print("berjalan di thread " + Thread.currentThread().getName());
                    System.out.println(" selama " + i + " detik");
                }catch (InterruptedException e){
                    return;
                }
            }
        };

        var thread = new Thread(runnable);
        thread.setName("hendy");
        System.out.println(thread.getState());
        thread.start();
        System.out.println(thread.getState());
        Thread.sleep(10000);
        System.out.println(thread.getState());
        Thread.sleep(10000);
        thread.interrupt();
        thread.join();
        Thread.State state = thread.getState();
        System.out.println(state);
    }

    @Test
    void daemonTest() throws InterruptedException {
        var thread = new Thread(() -> {
            try {
                Thread.sleep(5000);
                System.out.println("Berjalan di Thread");
            }catch (InterruptedException e){
                return;
            }
        });
        thread.start();
        System.out.println("program berhenti");
//        thread.join();
    }
}
