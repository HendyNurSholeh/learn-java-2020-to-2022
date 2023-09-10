package programmerzamannow.reflection;

import org.junit.jupiter.api.Test;
import programmerzamannow.reflection.data.Person;

import java.lang.reflect.Field;
import java.util.Arrays;

public class FieldTest {

    @Test
    void create() throws NoSuchFieldException {
        Class<Person> personClass = Person.class;
        Field[] declaredFields = personClass.getDeclaredFields();
        Field[] fields = personClass.getFields();
        System.out.println(Arrays.toString(declaredFields));
        System.out.println(Arrays.toString(fields));
        for (int i = 0; i < declaredFields.length; i++) {
            System.out.println(declaredFields[i].getName());
            System.out.println(declaredFields[i].getType());
            System.out.println(declaredFields[i].getModifiers());
        }

        Field firstName = personClass.getDeclaredField("firstName");
        System.out.println(firstName.getName());
        System.out.println(firstName.getType());
    }

    @Test
    void testFieldObject() throws NoSuchFieldException, IllegalAccessException {
        Person person1 = new Person();

        Class<Person> personClass = Person.class;
        Field field = personClass.getDeclaredField("firstName");
        field.setAccessible(true);

        System.out.println(field.get(person1));
        field.set(person1, "hendy");

        System.out.println(field.get(person1));


    }
}
