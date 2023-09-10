package programmerzamannow.reflection;

import org.junit.jupiter.api.Test;
import programmerzamannow.reflection.data.Person;

import java.util.Arrays;

public class PackageTest {
    @Test
    void getPackage() {
        Class<Person> personClass = Person.class;
        System.out.println(personClass);
        System.out.println(personClass.getName());
        Package aPackage = personClass.getPackage();
        System.out.println("===========");
        System.out.println(aPackage.getName());
        System.out.println(Arrays.toString(aPackage.getAnnotations()));
    }
}
