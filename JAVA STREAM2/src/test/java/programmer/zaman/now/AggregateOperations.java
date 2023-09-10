package programmer.zaman.now;

import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.List;

public class AggregateOperations {

    @Test
    void testMax() {
        List.of(1,2,3,4,5,35,5,6,7,4,4,3456,65,7).stream()
                .max(Comparator.naturalOrder()).ifPresent(System.out::println);
    }

    @Test
    void testMin() {
        List.of(1,2,3,4,5,35,5,6,7,4,4,3456,65,7).stream()
                .min(Comparator.naturalOrder()).ifPresent(System.out::println);
    }

    @Test
    void testCount() {
        long count = List.of(1, 2, 3, 4, 5, 35, 5, 6, 7, 4, 4, 3456, 65, 7).stream()
                .count();
        System.out.println(count);
    }

    @Test
    void testReduceSum() {
        Integer sum = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9).stream()
                .reduce(0, (number, result) -> number + result);
        System.out.println(sum);
    }

    @Test
    void testRedueFactorial() {
        Integer factorial = List.of(1, 2, 3, 4).stream()
                .reduce(1, (number, result) -> number * result);
        System.out.println(factorial);
    }
}
