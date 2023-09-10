package programmer.zaman.now.collection;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ListApp {
    public static void main(String[] args) {
        List<String> list1 = new ArrayList<>(100);
//        Collection<String> list2 = new ArrayList<>();

        list1.add("hendy");
        list1.add("hendy1");
        list1.add("hendy2");

        list1.remove(0);
        list1.remove(1);

        for (var name : list1) {
            System.out.println(name);
        }

    }
}
