package programmer.zaman.now.collection;

import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Map;

public class IdentityHashMapApp {
    public static void main(String[] args) {

        Map<String,String> map = new IdentityHashMap<>();

        String key = "name.first";

        String name = "name";
        String dot = ".";
        String first = "first";

        String key2 = name + dot + first;

        System.out.println(key.equals(key2));
        System.out.println(key == key2);

        map.put(key, "Eko");
        map.put(key2, "Eko");

        System.out.println(map.size());

    }
}
