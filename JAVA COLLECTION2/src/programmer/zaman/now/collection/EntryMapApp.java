package programmer.zaman.now.collection;

import java.security.KeyStore;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class EntryMapApp {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.putAll(Map.of("hendy","hendy","nur","nur","sholeh","sholeh"));
        Set<Map.Entry<String, String>> set = map.entrySet();

        for (var value : set){
            System.out.println(value.getKey() + ":" + value.getValue() );
        }

    }
}
