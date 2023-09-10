package programmer.zaman.now;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

public class RetriviengOperations {

    @Test
    void methodRetrivingOperation() {
        List<Integer> numbers = List.of(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20);
        System.out.println("limit (5)");
        numbers.stream().limit(5).forEach(System.out::println);
        System.out.println("skip (5)");
        numbers.stream().skip(5).forEach(System.out::println);
        System.out.println("take while (< 10)");
        numbers.stream().takeWhile(number -> number < 10).forEach(System.out::println);
        System.out.println("drop while (< 15)");
        numbers.stream().dropWhile(number -> number < 15).forEach(System.out::println);
    }

    @Test
    void retrivingSingleElement() {
        List<String> numbers = List.of("hendy", "nur", "sholeh");
        numbers.stream().findFirst().stream().forEach(System.out::println);

    }
}


