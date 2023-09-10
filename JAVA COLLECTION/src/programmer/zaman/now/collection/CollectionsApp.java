package programmer.zaman.now.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CollectionsApp {
    public static void main(String[] args) {

        List<String> list = new ArrayList<>();
        list.addAll(List.of("Eko","Kurniawan","Khannedy","Programmer","Zaman","Now"));

        System.out.println(list);

        Collections.reverse(list);
        System.out.println(list);

        Collections.swap(list,0,1);
        System.out.println(list);
    }
}
