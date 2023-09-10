package programmer.zaman.now.thread;

import java.util.concurrent.atomic.AtomicLong;

public class CounterAtomic {

    private AtomicLong value = new AtomicLong();

    public void increment(){
        value.incrementAndGet();
    }

    public AtomicLong getValue(){
        return value;
    }
}
