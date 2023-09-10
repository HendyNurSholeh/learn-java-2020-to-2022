package programmer.zaman.now.collection;

import java.util.Collections;
import java.util.NavigableSet;
import java.util.Set;
import java.util.TreeSet;

public class NavigableSetApp {
    public static void main(String[] args) {

        NavigableSet<String> names = new TreeSet<>() ;
        names.addAll(Set.of("Eko","Kurniawan","Khannedy","Programmer","Zaman","Now"));

        NavigableSet<String> namesReverse = names.descendingSet();
        NavigableSet<String> kurniawan = names.tailSet("Kurniawan",true);

        for (var name : kurniawan){
            System.out.println(name);
        }

        NavigableSet<String> immutable = Collections.unmodifiableNavigableSet(names);
        // immutable.add("hh");

    }
}
