package programmer.zaman.now.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class imuttableApp {
    public static void main(String[] args) {

        List<String> one = Collections.singletonList("Satu");
        List<String> empty = Collections.emptyList();

        List<String> mutable = new ArrayList<>();
        mutable.add("Eko");
        mutable.add("Kurniawan");
        List<String> immutable = Collections.unmodifiableList(mutable);

        List<String> elements = List.of("Eko","Kurniawan","Khannedy");
        for (var value : elements){
            System.out.println(value);
        }


    }
}
