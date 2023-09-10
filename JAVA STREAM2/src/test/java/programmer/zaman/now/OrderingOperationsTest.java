package programmer.zaman.now;

import org.junit.jupiter.api.Test;
import programmer.zaman.now.utility.Person;
import programmer.zaman.now.utility.PersonComparator;

import java.util.Comparator;
import java.util.List;

public class OrderingOperationsTest {

    @Test
    void testSorted() {
        List.of("d","a","e","b","c","f").stream().sorted().forEach(System.out::println);
    }

    @Test
    void testSortedWithComparator() {
        Person person1 = new Person("naruto", "konoha");
        Person person2 = new Person("luffy", "GrandLine");

        List.of(person1, person2).stream().sorted(new PersonComparator())
                .forEach(person -> {
                    System.out.println("Name    : " + person.getName());
                    System.out.println("Address : " + person.getAddress());
                });
    }
}
