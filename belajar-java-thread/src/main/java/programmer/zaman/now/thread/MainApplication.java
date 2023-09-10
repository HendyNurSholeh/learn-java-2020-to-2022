package programmer.zaman.now.thread;

import java.util.ArrayList;

public class MainApplication {
    public static void main(String[] args) {
        ThreadLocal<String> threadLocal = new ThreadLocal<>();
        threadLocal.set("hendy");
        threadLocal.set("hendy2");
        System.out.println(threadLocal.get());
    }
}
