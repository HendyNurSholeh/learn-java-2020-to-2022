package programmer.zaman.now;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class LazyOperationTest {

    @Test
    void intermediateOperation() {
        List<String> list = List.of("hendy", "luffy");
        list.stream()
                .map(value -> value.toUpperCase() + " GANTENG")
                .map(value -> {
                    System.out.println(value);
                    return value;
                });
    }

    @Test
    void terminalOperation() {
        List<String> list = List.of("boboy-boy", "adudu");
        list.stream().forEach(System.out::println);
    }
}
