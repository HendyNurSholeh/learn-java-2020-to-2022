package programmer.zaman.now.collection;

import java.util.HashMap;
import java.util.Map;

public class MapDefaultMethodApp {
    public static void main(String[] args) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 1; i < 100; i++) {
            map.put(i,i+1);
        }

        map.forEach((integer, integer2) -> System.out.println(integer + " : " + integer2));

    }
}
