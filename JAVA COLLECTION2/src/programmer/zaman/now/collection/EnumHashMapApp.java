package programmer.zaman.now.collection;

import java.util.EnumMap;
import java.util.Map;

public class EnumHashMapApp {
    public static enum Enum{
        LAKI2, PEREMPUAN, BENCONG
    }

    public static void main(String[] args) {
        Map<Enum, String> map = new EnumMap<>(Enum.class);
        map.put(Enum.LAKI2, "FARHAN");
        map.put(Enum.LAKI2, "FARHAN2");
        map.put(Enum.PEREMPUAN, "siti");

        for (var value : map.values()){
            System.out.println(value);
        }
    }
}
