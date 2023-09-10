package programmer.zaman.now.collection;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class ImmutableSetApp {
    public static void main(String[] args) {
        Set<String> empty = Collections.emptySet();
        Set<String> one = Collections.singleton("Eko");

        Set<String> mutable = new HashSet<>();
        mutable.add("Eko");
        mutable.add("Kurniawan");
        Set<String> immutable = Collections.unmodifiableSet(mutable);

        Set<String> set = Set.of("Eko","Kurniawan");

//        set.add("BB") // EROR
//        set.remove("Eko"); // //ERROR
    }
}
