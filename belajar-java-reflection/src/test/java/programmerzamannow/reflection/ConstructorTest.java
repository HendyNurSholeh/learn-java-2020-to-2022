package programmerzamannow.reflection;

import org.junit.jupiter.api.Test;
import programmerzamannow.reflection.data.Person;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Parameter;
import java.util.Arrays;

public class ConstructorTest {

    @Test
    void testCreate() {
        Class<Person> personClass = Person.class;
        Constructor<?>[] constructors = personClass.getDeclaredConstructors();
        for (var constructor:constructors) {
            System.out.println("=======" + constructor.getName() + "=======");
            System.out.println(constructor.getModifiers());
            System.out.println(Arrays.toString(constructor.getParameterTypes()));
            Parameter[] parameters = constructor.getParameters();
            for (var parameter:parameters) {
                System.out.println(parameter.getType());
            }
        }
    }

    @Test
    void testRunningConstructor() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class<Person> personClass = Person.class;

        Constructor<Person> defaultConstructor = personClass.getConstructor();
        System.out.println(defaultConstructor.getName());
        System.out.println(Arrays.toString(defaultConstructor.getParameterTypes()));
        Person person = defaultConstructor.newInstance();
        System.out.println(person.getFirstName());
        System.out.println(person.getLastName());

        System.out.println("====================");

        Constructor<Person> defaultConstructor2 = personClass.getConstructor(String.class, String.class);
        System.out.println(defaultConstructor2.getName());
        System.out.println(Arrays.toString(defaultConstructor2.getParameterTypes()));
        Person person2 = defaultConstructor2.newInstance("hendy", "Sholeh");
        System.out.println(person2.getFirstName());
        System.out.println(person2.getLastName());    }
}
