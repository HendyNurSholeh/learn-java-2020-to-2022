package programmer.zaman.now.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class BinarySearchApp {
    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= 1000; i++) {
            list.add(i);
        }


        int index = Collections.binarySearch(list,333);
        System.out.println(index);

        Comparator<String> reverse = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        };

        int index2 = Collections.binarySearch(list,333);
        System.out.println(index2);



    }
}
