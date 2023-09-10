package programmer.zaman.now.lambda;

import java.util.function.Consumer;

public class ConsumerApp {
    public static void main(String[] args) {
        Consumer<String> consumer = value -> System.out.println("Hello " + value);
        consumer.accept("hendy");
    }
}
