package programmerzamannow.reflection;

import org.junit.jupiter.api.Test;
import programmerzamannow.reflection.data.Person;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.Arrays;

public class ParameterTest {

    @Test
    void testCreate() {
        Class<Person> personClass = Person.class;
        Method[] declaredMethods = personClass.getDeclaredMethods();
        for (var method:declaredMethods) {
            System.out.println(method.getName());
            Parameter[] parameters = method.getParameters();
        }
    }

    @Test
    void testParameterMethod() {
        Class<Person> personClass = Person.class;
        Method[] declaredMethods = personClass.getDeclaredMethods();
        for (var method:declaredMethods) {
            System.out.println("\nMethod : " + method.getName());
            Parameter[] parameters = method.getParameters();
            for (Parameter parameter:parameters){
                System.out.println(parameter.getName());
                System.out.println(parameter.getType());
                System.out.println(parameter.getModifiers());
            }
        }
    }
}
