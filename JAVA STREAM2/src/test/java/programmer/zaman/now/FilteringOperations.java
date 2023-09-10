package programmer.zaman.now;

import org.junit.jupiter.api.Test;

import java.io.LineNumberInputStream;
import java.util.List;
import java.util.stream.Stream;

public class FilteringOperations {

    @Test
    void filterAndDistincTest() {
        List<Integer> list = List.of(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20);
        list.stream().flatMap(value -> Stream.of(value, value))
                .filter(value -> !(value % 2 == 0 && value % 3 == 0))
                .distinct()
                .forEach(System.out::println);
    }
}
