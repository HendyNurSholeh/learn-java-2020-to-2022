package programmerzamannow.reflection;

import org.junit.jupiter.api.Test;
import programmerzamannow.reflection.data.Person;

public class SuperClassTest {

    @Test
    void create() {
        Class<Person> personClass = Person.class;
        System.out.println(personClass);

        Class<? super Person> superclass = personClass.getSuperclass();
        System.out.println(superclass);

        Class<? super Person> superclassAtasnyaLagi = superclass.getSuperclass();
        System.out.println(superclassAtasnyaLagi);
    }
}
