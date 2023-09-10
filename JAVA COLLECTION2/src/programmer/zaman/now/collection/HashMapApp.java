package programmer.zaman.now.collection;

import java.util.HashMap;
import java.util.Map;

public class HashMapApp {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();
        map.putAll(Map.of(1,"hendy1",3,"hendy2",2,"hendy1"));
        map.put(1, "hendyNew");

        for (var value : map.entrySet()){
            System.out.println(value.getKey() + " : " + value.getValue());
        }
    }
}
