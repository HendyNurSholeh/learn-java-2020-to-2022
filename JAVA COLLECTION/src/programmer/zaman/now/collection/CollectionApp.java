package programmer.zaman.now.collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class CollectionApp {
    public static void main(String[] args) {

        Collection<String> collection = new ArrayList<>();

        collection.add("Eko");
        collection.add("Kurniawan");
        collection.add("Khannedy");
        collection.addAll(List.of("Programmer","Zaman","Now"));

        for (var value : collection){
            System.out.println(value);
        }

        System.out.println("\nREMOVE");

        collection.remove("Eko");
        collection.removeAll(List.of("Zaman","Now"));

        for (var value : collection){
            System.out.println(value);
        }

        System.out.println(collection.contains("Kurniawan"));
        System.out.println(collection.containsAll(List.of("Khannedy","Programmer")));

        System.out.println(collection.size());
    }
}
