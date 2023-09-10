package programmerzamannow.lombok;

import lombok.Getter;
import lombok.Synchronized;

public class Counter {

    private final Object lock = new Object();

    @Getter
    private Long counter = 0L;

    @Synchronized(value = "lock")
    public void increment(){
        counter += 1;
    }
}
