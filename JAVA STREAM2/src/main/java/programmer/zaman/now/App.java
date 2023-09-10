package programmer.zaman.now;

import java.util.stream.Stream;

/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args ) {
        Stream<String> stream = Stream.of("hendy");
        stream.forEach(System.out::println);
    }
}
