package programmer.zaman.now;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class CreateStreamTest {

    @Test
    void createStream() {
        Stream<String> stream = Stream.of("Hendy");
        Stream<String> streamOfNull = Stream.ofNullable(null);
        Stream<String> streamEmpty = Stream.empty();
        stream.forEach(System.out::println);
        streamOfNull.forEach(System.out::println);
        streamEmpty.forEach(System.out::println);
    }

    @Test
    void createStreamArray() {
        Stream<String> stream = Stream.of("Hendy", "Nur", "Sholeh");
        stream.forEach(System.out::println);

        String array[] = {"hendy", "nur"};
        Stream<String> arrayStream = Arrays.stream(array);
        arrayStream.forEach(System.out::println);
    }

    @Test
    void createStreamInCollection() {
        List<String> list = new ArrayList<>();
        Stream<String> stream = list.stream();
        stream.forEach(System.out::println);
//        stream.forEach(System.out::println); // ERROR STREAM CUMA BISA DIJALANKAN SEKALI
    }

    @Test
    void createInfiniteStream() {
        Stream<Integer> infiniteWithGenerate = Stream.generate(() -> 2);
//        infiniteWithGenerate.forEach(System.out::println);
        Stream<String> infiniteWithIterate = Stream.iterate("hendy", value -> value + "y");
        infiniteWithIterate.forEach(System.out::println);
    }

    @Test
    void createStreamBuilder() {
        Stream.Builder<String> builder = Stream.builder();
        builder.accept("hendy");
        builder.add("nur").add("sholeh");
        Stream<String> stream = builder.build();
        stream.forEach(System.out::println);
    }


}
