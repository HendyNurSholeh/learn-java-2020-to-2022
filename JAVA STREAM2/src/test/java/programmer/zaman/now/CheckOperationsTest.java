package programmer.zaman.now;

import org.junit.jupiter.api.Test;

import java.util.List;

public class CheckOperationsTest {

    @Test
    void testAllMatch() {
        boolean isGanjil = List.of(1, 3, 5, 7, 9).stream().allMatch(number -> number % 2 == 1);
        System.out.println(isGanjil);
    }

    @Test
    void testAnyMatch() {
        boolean searchValue5 = List.of(1, 3, 5, 7, 9).stream().anyMatch(value -> value == 5);
        System.out.println(searchValue5);
    }

    @Test
    void test() {
        boolean isNotGenap = List.of(1, 3, 5, 7, 9).stream().noneMatch(value -> value % 2 == 0);
        System.out.println(isNotGenap);
    }
}
