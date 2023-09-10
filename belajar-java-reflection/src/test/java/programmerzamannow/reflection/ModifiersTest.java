package programmerzamannow.reflection;

import org.junit.jupiter.api.Test;
import programmerzamannow.reflection.data.Person;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class ModifiersTest {

    @Test
    void testModifier() {
        Class<Person> personClass = Person.class;
        System.out.println(Modifier.isPublic(personClass.getModifiers()));
        System.out.println(Modifier.isPrivate(personClass.getModifiers()));
        System.out.println(Modifier.isStatic(personClass.getModifiers()));

        Field[] declaredFields = personClass.getDeclaredFields();
        for (var field : declaredFields) {
            System.out.println("============");
            System.out.println(field.getName());
            System.out.println(Modifier.isPublic(field.getModifiers()));
            System.out.println(Modifier.isPrivate(field.getModifiers()));
            System.out.println(Modifier.isStatic(field.getModifiers()));
        }
    }
}
