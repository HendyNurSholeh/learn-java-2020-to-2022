package programmer.zaman.now.collection;

import programmer.zaman.now.collection.data.Person;
import programmer.zaman.now.collection.data.PersonComparator2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class BinarySearchApp {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.addAll(List.of("g","f","e","a","c","d","b"));

        Collections.sort(list);
        System.out.println(list);

        Collections.reverse(list);
        System.out.println(list);

        Collections.shuffle(list);
        System.out.println(list);
//        Collections.sort(list);

//        int index = Collections.binarySearch(list, "b");
//        System.out.println(index);
//
//        for (var value : list){
//            System.out.println(value);
//        }

//        Person person = new Person("c")

//        System.out.println(index);
    }
}
