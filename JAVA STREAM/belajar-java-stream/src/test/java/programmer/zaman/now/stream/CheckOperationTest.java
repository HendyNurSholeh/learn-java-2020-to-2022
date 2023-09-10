package programmer.zaman.now.stream;

import org.junit.jupiter.api.Test;

import java.util.List;

public class CheckOperationTest {

    @Test
    void testAnyMatch() {
        boolean anyMatch = List.of(1,2,3,4,5,6,7,8,9,10).stream()
                .anyMatch(value -> value > 20);
        System.out.println(anyMatch);
    }

    @Test
    void testAllMatch() {
        boolean allMatch = List.of(1,2,3,4,5,6,7,8,9,10).stream()
                .allMatch(value -> value > 20);
        System.out.println(allMatch);
    }

    @Test
    void testNoneMacth() {
        boolean noneMatch = List.of(1,2,3,4,5,6,7,8,9,10).stream()
                .noneMatch(value -> value > 20);
        System.out.println(noneMatch);
    }
}
