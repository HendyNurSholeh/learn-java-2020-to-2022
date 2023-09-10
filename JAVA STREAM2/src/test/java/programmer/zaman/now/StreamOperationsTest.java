package programmer.zaman.now;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Stream;

public class StreamOperationsTest {

    @Test
    void streamOperations() {
        List<String> names = List.of("hendy", "nur", "sholeh");

        // STREAM OPERATIONS
        names.stream().map(name -> "Mr. " + name.toUpperCase()).forEach(System.out::println);
        // yg sebenarnya dilakukan (JARANG DIGUNAKAN)
        Stream<String> stream = names.stream();
        Stream<String> streamUpper = stream.map(String::toUpperCase);
        streamUpper.forEach(System.out::println);



    }

}
