package programmer.zaman.now;

import org.junit.jupiter.api.Test;

import java.util.stream.Stream;

public class ParallelStreamTest {

    @Test
    void testSequential() {
        Stream.of(1,2,3,4,5,6,7,8,9,10).forEach(number -> System.out.println(Thread.currentThread().getName() + " : " + number));
    }

    @Test
    void testParallelStream() {
        Stream.of(1,2,3,4,5,6,77, 77,545).parallel()
                .forEach(number -> System.out.println(Thread.currentThread().getName() + " : " + number));
    }
}
