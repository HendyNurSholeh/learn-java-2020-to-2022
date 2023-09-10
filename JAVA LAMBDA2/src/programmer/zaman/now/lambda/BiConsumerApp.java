package programmer.zaman.now.lambda;

import java.util.HashMap;
import java.util.Map;

public class BiConsumerApp {
    public static void main(String[] args) {
        Map<String, String> map = Map.of("a","aV", "b","bV", "c","cV");
        map.forEach((key, value) -> System.out.println(key + " : " + value));
    }

}
