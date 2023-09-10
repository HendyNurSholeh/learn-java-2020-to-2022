package programmer.zaman.now.collection;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class EntryApp {
    public static void main(String[] args) {

        Map<String, String> map = new HashMap<>();

        map.put("Eko","Eko");
        map.put("Budi","Budi");
        map.put("Joko","Joko");

        Set<Map.Entry<String, String>> entries = map.entrySet();

        for (var entry : entries){
            System.out.println("Key : "+entry.getKey()+"    Value : "+entry.getValue() );
        }
    }
}
