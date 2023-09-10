package programmer.zaman.now.collection;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class ImmutableSet {
    public static void main(String[] args) {
        Set<String> empty = Collections.emptySet();
        Set<String> one = Collections.singleton("hendy");
        Set<String> Sets = Set.of("hendy");

        Set<String> set = new HashSet<>();
        Set<String> immutableSet = Collections.unmodifiableSet(set);
//        immutableSet.add("duarr");

    }
}
