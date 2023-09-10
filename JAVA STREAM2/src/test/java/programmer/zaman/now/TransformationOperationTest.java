package programmer.zaman.now;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Stream;

public class TransformationOperationTest {

    @Test
    void mapAndFlatMapTest() {
        List.of(1, 2, 3, 4, 5).stream()
                .flatMap(value -> Stream.of(value, value * 10))
                .forEach(value -> System.out.println(value + "\t+\t" + value + "\t: " + value * 2));
    }
}
