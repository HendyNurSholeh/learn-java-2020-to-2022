package programmer.zaman.now.stream;

import org.junit.jupiter.api.Test;

import java.util.List;

public class ForEachOperationTest {
    @Test
    void testPeekBefore() {
        List.of("Eko", "Kurniawan", "Khannedy").stream()
                .map(name -> {
                    System.out.println("Before Change name o upper : " + name);
                    name.toUpperCase();
                    System.out.println("Change name o upper : " + name);
                    return name;
                })
                .forEach(System.out::println);
    }

    @Test
    void testPeekAfter() {
        List.of("Eko", "Kurniawan", "Khannedy").stream()
                .peek(upper -> System.out.println("Before Change name o upper : " + upper))
                .map(name -> name.toUpperCase())
                .peek(name -> System.out.println("Before Change name o upper : " + name))
                .forEach(System.out::println);
    }
}
