package programmer.zaman.now;

import org.junit.jupiter.api.Test;

import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class PrimitiveStreamTest {

    @Test
    void testIntPrimitiveStream() {
        IntStream.of(1, 2, 3, 4, 5, 6)
                .average().ifPresent(System.out::println);
    }

    @Test
    void testDoublePrimitiveStream() {
        DoubleStream.of(1, 2, 3, 4, 5, 6)
                .filter(number -> !(number > 3))
                .forEach(System.out::println);
    }

    @Test
    void testLongPrimitiveStream() {
        LongStream.of(1, 2, 3, 4, 5, 6)
                .filter(number -> !(number > 3))
                .forEach(System.out::println);
    }
}
