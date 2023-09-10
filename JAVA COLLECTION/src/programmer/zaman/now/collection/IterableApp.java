package programmer.zaman.now.collection;

import java.util.Iterator;
import java.util.List;

public class IterableApp {
    public static void main(String[] args) {

        Iterable<String> names = List.of("Eko", "Kurniawan", "Khannedy");
        for (var name : names){
            System.out.println(name);
        }

        System.out.println("ITERATOR");
        Iterator<String> iterator = names.iterator();

        while (iterator.hasNext()){
            String name = iterator.next();
            System.out.println(name);
        }
    }

}
