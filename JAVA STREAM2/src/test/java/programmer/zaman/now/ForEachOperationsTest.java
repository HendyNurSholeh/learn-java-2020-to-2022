package programmer.zaman.now;

import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.List;

public class ForEachOperationsTest {

    @Test
    void testForEach() {
        List.of("hendy", "nur", "sholeh").forEach(System.out::println);
    }

    @Test
    void testPeek() {
        List.of("hendy", "nur", "sholeh").stream().peek(System.out::println).max(Comparator.naturalOrder());
    }
}
