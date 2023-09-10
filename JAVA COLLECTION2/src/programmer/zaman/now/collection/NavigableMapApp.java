package programmer.zaman.now.collection;

import programmer.zaman.now.collection.data.Person;

import java.util.NavigableMap;
import java.util.TreeMap;

public class NavigableMapApp {
    public static void main(String[] args) {
        NavigableMap<String, String> navigableMap = new TreeMap<>();
        navigableMap.put("hello", "hello");
        navigableMap.put("hello2", "hello");
        navigableMap.put("hello3", "hello");
        navigableMap.put("hello1", "hello");

        String navigableMap1 = navigableMap.lowerKey("hello2");
        System.out.println(navigableMap1);

        for (var value : navigableMap.keySet()){
            System.out.println(value);
        }

    }
}
