package programmer.zaman.now.collection;

import java.util.*;

public class LinkedHashMapApp {
    public static void main(String[] args) {

        Map<String,String> map = new LinkedHashMap<>();

        map.put("first", "Eko");
        map.put("last", "Khannedy");
        map.put("middle", "Kurniawan");

        Set<String> keys = map.keySet();

        for (var value:keys) {
            System.out.println(map.get(value));
        }
    }
}
