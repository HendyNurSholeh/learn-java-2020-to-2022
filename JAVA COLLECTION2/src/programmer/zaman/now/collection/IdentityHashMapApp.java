package programmer.zaman.now.collection;

import java.util.*;

public class IdentityHashMapApp {
    public static void main(String[] args) {
        Map<String, Integer> map = new IdentityHashMap<>();
        String key1 = "usop.keren";
        String satu = "usop";
        String dot = ".";
        String key2 = satu + dot + "keren";

        map.put(key1, 4);
        map.put(key2, 4);

        System.out.println(map.size());


    }
}
