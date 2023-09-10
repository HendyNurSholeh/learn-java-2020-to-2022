package programmer.zaman.now.collection;

import java.util.LinkedHashMap;
import java.util.Map;

public class LinkedHashMapApp {
    public static void main(String[] args) {
        Map<String, String> map = new LinkedHashMap<>();

        map.put("d","a");
        map.put("c","b");
        map.put("b","c");
        map.put("a","d");

        for (var value : map.values()){
            System.out.println(value);
        }
    }
}
