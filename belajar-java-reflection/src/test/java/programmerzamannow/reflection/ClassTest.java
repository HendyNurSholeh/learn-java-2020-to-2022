package programmerzamannow.reflection;

import org.junit.jupiter.api.Test;
import programmerzamannow.reflection.data.Person;

import java.util.Arrays;

public class ClassTest {

    @Test
    void testCreateClass() throws ClassNotFoundException {
        Class<Person> personClass = Person.class;

        Class<?> aClass1 = Class.forName("programmerzamannow.reflection.data.Person");

        var person = new Person();
        Class<? extends Person> aClass = person.getClass();
    }

    @Test
    void testClassToGet() {
        Class<Person> personClass = Person.class;
        System.out.println(personClass.getSuperclass());
        System.out.println(Arrays.toString(personClass.getInterfaces()));
        System.out.println(Arrays.toString(personClass.getDeclaredConstructors()));
        System.out.println(Arrays.toString(personClass.getDeclaredFields()));
        System.out.println(Arrays.toString(personClass.getDeclaredMethods()));
        System.out.println(Arrays.toString(personClass.getDeclaredClasses()));
        System.out.println(personClass.getModule());
        System.out.println(personClass.getName());
        System.out.println(personClass.getSimpleName());
        System.out.println(personClass.getModifiers());
        System.out.println(personClass.getPackage());
    }
}
