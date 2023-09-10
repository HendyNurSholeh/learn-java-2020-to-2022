package programmer.zaman.now.collection;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

public class MapDefaultMethodApp {
    public static void main(String[] args) {

        Map<String, String> map = new HashMap<>();
        map.put("Eko","Eko");
        map.put("Budi","Budi");
        map.put("Joko","Joko");

        map.forEach(new BiConsumer<String, String>() {
            @Override
            public void accept(String key, String value) {
                System.out.println("Key : "+key+"   Value : "+value);
            }
        });


    }
}
