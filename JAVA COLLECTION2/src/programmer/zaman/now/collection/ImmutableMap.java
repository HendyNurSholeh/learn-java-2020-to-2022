package programmer.zaman.now.collection;

import programmer.zaman.now.collection.data.Person;

import java.util.*;

public class ImmutableMap {
    public static void main(String[] args) {
        SortedMap<Person, String> map = new TreeMap<>((o1, o2) -> o2.getName().compareTo(o1.getName()));
        map.put(new Person("b"), "nomer 3");
        map.put(new Person("a"), "nomer 2");
        map.put(new Person("d"), "nomer 1");
        map.put(new Person("c"), "nomer 4");



//        Map<String, String> unmodifiableMap = Collections.unmodifiableMap(map);

//        unmodifiableMap.put("ups", "salah");
        for (var value : map.keySet()){
            System.out.println(value.getName());
        }

        System.out.println(map.size());


    }
}
