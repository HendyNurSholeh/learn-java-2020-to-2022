package programmer.zaman.now;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GrupingByTest {

    @Test
    void testGrupingBy() {
        List<String> names = List.of("hendy", "nur", "sholeh", "zoro");
        Map<String, List<String>> grupingBy = names.stream()
                .collect(Collectors.groupingBy(name -> name.length() > 4 ? "longName" : "shortName"));
        for (var values:grupingBy.entrySet()) {
            System.out.println(values.getKey() + " : ");
            values.getValue().forEach(value-> System.out.println("- " + value));
        }
    }

    @Test
    void testPartitioningBy() {
        List<Integer> numbers = List.of(1, 435, 3, 5436, 6, 7, 7, 8, 4, 6, 3, 36, 75);

        Map<Boolean, List<Integer>> partitioningBy = numbers.stream()
                .collect(Collectors.partitioningBy(number -> number > 100));

        partitioningBy.forEach((key, value) -> System.out.println(key + " : " + value));

    }
}
