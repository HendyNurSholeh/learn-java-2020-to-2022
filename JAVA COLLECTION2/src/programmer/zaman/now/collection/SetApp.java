package programmer.zaman.now.collection;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class SetApp {
    public static void main(String[] args) {
        Set<Integer> names = new HashSet<>();
        names.add(3);
        names.add(4);
        names.add(2);
        names.add(1);
        for (var name : names) {
            System.out.println(name);
        }

    }
}
