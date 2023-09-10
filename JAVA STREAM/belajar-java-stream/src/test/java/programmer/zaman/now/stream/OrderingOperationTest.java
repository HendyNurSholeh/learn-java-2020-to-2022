package programmer.zaman.now.stream;

import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.List;

public class OrderingOperationTest {

    @Test
    void testSorted() {
        List.of("Eko", "Kurniawan", "Khannedy", "Programmer", "Zaman", "Now").stream()
                .sorted()
                .forEach(System.out::println);
    }

    @Test
    void testSortedWithComparator() {
        List.of("Eko", "Kurniawan", "Khannedy", "Programmer", "Zaman", "Now").stream()
                .sorted(Comparator.reverseOrder())
                .forEach(System.out::println);
    }
}
