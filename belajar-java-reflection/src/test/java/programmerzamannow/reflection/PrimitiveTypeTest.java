package programmerzamannow.reflection;

import org.junit.jupiter.api.Test;
import programmerzamannow.reflection.data.Person;
import programmerzamannow.reflection.data.TypePrimitive;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.security.Permission;
import java.util.Arrays;

public class PrimitiveTypeTest {

    @Test
    void testClass() {
        Class<Integer> integerClass = int.class;
        System.out.println(Arrays.toString(integerClass.getDeclaredFields()));
        System.out.println(Arrays.toString(integerClass.getDeclaredMethods()));
        System.out.println(integerClass.isPrimitive());
    }

    @Test
    void testField() throws NoSuchFieldException, IllegalAccessException {
        var person = new Person("hendy", "  ");
        Class<Person> personClass = Person.class;
        Field age = personClass.getDeclaredField("age");

        System.out.println(age.getType().isPrimitive());
        age.setAccessible(true);
        age.setInt(person, 16);
        System.out.println(age.get(person));
        System.out.println(age.getInt(person));
    }

    @Test
    void testMethod() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Class<Person> personClass = Person.class;
        var person = new Person();

        Method setAge = personClass.getDeclaredMethod("setAge", int.class);
        setAge.invoke(person, 16);

        System.out.println(person.getAge());


    }
}
