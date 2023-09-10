package programmer.zaman.now.collection;

import programmer.zaman.now.collection.data.Person;
import programmer.zaman.now.collection.data.PersonComparator;

import java.util.Collections;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

public class SortedSetApp {
    public static void main(String[] args) {
        SortedSet<Person> stringSortedSet = new TreeSet<>(new PersonComparator().reversed());
        stringSortedSet.add(new Person("c"));
        stringSortedSet.add(new Person("d"));
        stringSortedSet.add(new Person("b"));
        stringSortedSet.add(new Person("a"));

        SortedSet<Person>  immutablePerson = Collections.unmodifiableSortedSet(stringSortedSet);
//        immutablePerson.add(new Person("hedy")); // ERROR
        for (var value : immutablePerson){
            System.out.println(value.getName());
        }

        SortedSet<String> sortedSet = Collections.emptySortedSet();
//        Collections.unmodifiableSortedSet(sortedSet);
//        sortedSet.add("hoii");
        for (var value : sortedSet){
            System.out.println(value);
        }



    }
}
