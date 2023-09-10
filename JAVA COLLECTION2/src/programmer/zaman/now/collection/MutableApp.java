package programmer.zaman.now.collection;

import programmer.zaman.now.collection.data.Person;

import java.util.*;

public class MutableApp {
    public static void main(String[] args) {
        List<String> address = List.of("hendy");
        System.out.println(address.get(0));
//        address.add("hendy");
        for (var value : address){
            System.out.println(value);
        }

        
        List<String> names = new ArrayList<>();
        names.add("Ace");
        List<String> immutableNames = Collections.unmodifiableList(names);
//        immutableNames.add("usoppp");
        for (var name:names) {
            System.out.println(name);
        }


        System.out.println("\n\n");
        Person person = new Person("usop");
        person.addHobby("belajar");
        doSomethingWithHobbies(person.getHobbies());
//        Collections.unmodifiableList(person.getHobbies());
        person.addHobby("Coding");
        for (var hobby:person.getHobbies()) {
            System.out.println(hobby);
        }
    }

    static void doSomethingWithHobbies(List<String> list){
//        list.add("kelerang"); // ERROR karna sudah immutable list
    }
}
