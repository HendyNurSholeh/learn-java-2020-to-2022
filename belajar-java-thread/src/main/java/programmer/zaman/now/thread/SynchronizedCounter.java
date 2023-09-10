package programmer.zaman.now.thread;

public class SynchronizedCounter {
    private Long value = 0L;

    public void increment(){
        synchronized (value){
            value++;
        }
    }

    public Long getValue(){
        return value;
    }
}
