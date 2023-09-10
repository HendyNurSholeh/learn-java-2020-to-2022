package programmer.zaman.now.stream;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Stream;

public class CreateStreamBuilderTest {

    @Test
    void testCreateStreamBuilder() {
        Stream.Builder<String> builder = Stream.builder();
        builder.accept("Eko");
        builder.add("Kurniawan").add("Khannedy");

        Stream<String> stream = builder.build();
        stream.forEach(System.out::println);
    }

    @Test
    void testCreateStreamBuilderSimplyfy() {
        Stream<Object> stream = Stream.builder()
                .add("Eko").add("Kurniawan").add("Khannedy").build();
        stream.forEach(System.out::println);
    }

    @Test
    void testMapStream() {
        List<String> names = List.of("Eko", "Kurniawan", "Khannedy");
        Stream<String> streamNames = names.stream();
        Stream<String> streamUpper = streamNames.map(value -> value.toUpperCase());
        streamUpper.forEach(System.out::println);
        names.forEach(System.out::println);
    }

}
