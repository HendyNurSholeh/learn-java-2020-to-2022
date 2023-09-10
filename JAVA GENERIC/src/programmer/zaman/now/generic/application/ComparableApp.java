package programmer.zaman.now.generic.application;

import programmer.zaman.now.generic.util.Person;

import java.util.Arrays;

public class ComparableApp {
    public static void main(String[] args) {

        Person[] people={
                new Person("Eko","indonesia"),
                new Person("Budi","indonesia"),
                new Person("Joko","indonesia")};

        Arrays.sort(people);

        System.out.println(Arrays.toString(people));

    }
}
