package programmer.zaman.now.stream;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Stream;

public class StreamPipelineTest{

    @Test
    void testCreateStreamPipeline() {
        // JARANG DIGUNAKAN
        List<String> list = List.of("Eko", "Kurniawan", "Khannedy");

        Stream<String> stream = list.stream();

        Stream<String> upper = stream.map(value -> value.toUpperCase());

        Stream<String> mr = upper.map(value -> "Mr." + value);

        mr.forEach(System.out::println);
    }

    @Test
    void testStreamPipeline() {
        // SERING DIGUNAKAN
        List.of("Eko", "Kurniawan", "Khannedy").stream()
                .map(names -> names.toUpperCase())
                .map(upperNames -> "Mr." + upperNames)
                .forEach(System.out::println);
    }
}
