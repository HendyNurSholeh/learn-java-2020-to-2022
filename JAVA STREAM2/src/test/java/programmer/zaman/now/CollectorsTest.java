package programmer.zaman.now;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class CollectorsTest {

    @Test
    void createListWithCollect() {
        Set<Integer> numbers = Set.of(1,2,3,4,5);

        List<Integer> list = numbers.stream().collect(Collectors.toList());
        list.add(6);
        list.forEach(System.out::println);

        List<Integer> immutableList = numbers.stream().collect(Collectors.toUnmodifiableList());
        immutableList.forEach(System.out::println);
    }

    @Test
    void createSetWithColect() {
        List<Integer> numbers = List.of(1,2,3,4,5,6);

        Set<Integer> set = numbers.stream().collect(Collectors.toSet());
        set.forEach(System.out::println);

        Set<Integer> immutableSet = numbers.stream().collect(Collectors.toUnmodifiableSet());
        immutableSet.forEach(System.out::println);
    }

    @Test
    void createMapWithCollect() {
        List<String> names = List.of("eko", "hendy", "basro");
        Map<String, Integer> map = names.stream().collect(Collectors.toMap(name -> name, name -> name.length()));
        for (var value:map.entrySet()) {
            System.out.println(value.getKey() + " : " + value.getValue());
        }
    }

    @Test
    void createImmutableMapWithCollect() {
        List<String> names = List.of("eko", "hendy", "basro");
        Map<String, Integer> map = names.stream().collect(Collectors.toUnmodifiableMap(name -> name.toUpperCase(), name -> name.length()));
//        map.put("hendy", 5);
        for (var value:map.entrySet()) {
            System.out.println(value.getKey() + " : " + value.getValue());
        }
    }
}
