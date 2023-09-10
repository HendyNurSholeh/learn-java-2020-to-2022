package programmerzamannow.lombok;

import org.junit.jupiter.api.Test;

public class CounterTest {

    @Test
    void testSynchronized() throws InterruptedException {
        var counter = new Counter();

        for (int i = 0; i < 1000; i++) {
            new Thread(() -> {
                counter.increment();
            }).start();
        }
        Thread.sleep(1000);
        System.out.println(counter.getCounter());
    }
}
