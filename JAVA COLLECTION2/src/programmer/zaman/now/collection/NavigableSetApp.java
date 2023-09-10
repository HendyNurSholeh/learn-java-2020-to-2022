package programmer.zaman.now.collection;

import java.util.Collections;
import java.util.List;
import java.util.NavigableSet;
import java.util.TreeSet;

public class NavigableSetApp {
    public static void main(String[] args) {
        NavigableSet<String> names = new TreeSet<>();
        names.addAll(List.of("a","b","c","d"));
        NavigableSet<String> temp = names.headSet("b", true);
        for (var name : temp) {
            System.out.println(name);
        }

        NavigableSet<String> immutableNames = Collections.unmodifiableNavigableSet(names);
//        immutableNames.add("opss");
        for (var value : immutableNames){
            System.out.println(value);
        }

    }
}
