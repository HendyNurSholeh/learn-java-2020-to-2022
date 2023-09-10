package programmerzamannow.reflection;

import org.junit.jupiter.api.Test;
import programmerzamannow.reflection.data.Person;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

public class MethodTest {

    @Test
    void create() throws NoSuchMethodException {
        Class<Person> personClass = Person.class;
        Method getFirstName = personClass.getDeclaredMethod("getFirstName");
        Method getFirstName1 = personClass.getMethod("getFirstName");
        System.out.println(getFirstName);
        System.out.println(getFirstName1);
        System.out.println(Arrays.toString(personClass.getDeclaredMethods()));
        System.out.println(Arrays.toString(personClass.getMethods()));
        System.out.println(personClass.getEnclosingMethod());
    }

    @Test
    void testMethodFunction() {
        Class<Person> personClass = Person.class;
        Method[] methods = personClass.getMethods();
        for (var method:methods) {
            System.out.println(method.getName());
            System.out.println(method.getReturnType());
            System.out.println(method.getModifiers());
            System.out.println(method.getParameterCount());
        }
    }

    @Test
    void testRunningMethod() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        var person = new Person("hendy", "Nur Sholeh");

        Class<Person> personClass = Person.class;
        Method setFirstName = personClass.getMethod("setFirstName", String.class);
        Method getFirstName = personClass.getMethod("getFirstName");

        Object setValue = setFirstName.invoke(person, "huhuy");
        Object getValue = getFirstName.invoke(person);
        System.out.println(setValue);
        System.out.println(getValue);
    }
}
