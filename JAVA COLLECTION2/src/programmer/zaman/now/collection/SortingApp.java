package programmer.zaman.now.collection;

import programmer.zaman.now.collection.data.Person;
import programmer.zaman.now.collection.data.PersonComparator2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortingApp {
    public static void main(String[] args) {
//        List<String> list = new ArrayList<>();
//        list.addAll(List.of("f", "e", "a", "c", "b", "d"));
//
//        Collections.sort(list);
//
//        for(var value : list){
//            System.out.println(value);
//        }

        List<Person> list = new ArrayList<>();
        list.add(new Person("b"));
        list.add(new Person("c"));
        list.add(new Person("d"));
        list.add(new Person("e"));
        list.add(new Person("a"));
        list.add(new Person("f"));

        Collections.sort(list, new PersonComparator2());

        for (var value : list){
            System.out.println(value.getName());
        }


    }
}
