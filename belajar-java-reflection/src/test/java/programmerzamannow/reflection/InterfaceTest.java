package programmerzamannow.reflection;

import org.junit.jupiter.api.Test;
import programmerzamannow.reflection.data.Person;
import programmerzamannow.reflection.data.PersonInterface;

import java.io.Serializable;
import java.lang.reflect.Method;
import java.security.spec.RSAOtherPrimeInfo;
import java.util.Arrays;

public class InterfaceTest {

    @Test
    void create() {
        Class<PersonInterface> personInterfaceClass = PersonInterface.class;
        System.out.println(personInterfaceClass.isInterface());
    }

    @Test
    void differentBetweenClassAndInterface() throws NoSuchMethodException {
        Class<Person> personClass = Person.class;
        Class<PersonInterface> personInterfaceClass = PersonInterface.class;

        System.out.println(personClass.isInterface());
        System.out.println(personInterfaceClass.isInterface());

        System.out.println(personClass.getDeclaredConstructor());
        System.out.println(Arrays.toString(personInterfaceClass.getDeclaredConstructors()));

        System.out.println(Arrays.toString(personClass.getDeclaredFields()));
        System.out.println(Arrays.toString(personInterfaceClass.getDeclaredFields()));

        System.out.println(Arrays.toString(personClass.getDeclaredMethods()));
        System.out.println(Arrays.toString(personInterfaceClass.getDeclaredMethods()));

        Method getFirstName = personInterfaceClass.getDeclaredMethod("getFirstName");
        System.out.println(getFirstName.getGenericReturnType());
    }

    @Test
    void testSuperInterface() {
        Class<Person> personClass = Person.class;
        Class<?>[] interfaces = personClass.getInterfaces();
        System.out.println(Arrays.toString(interfaces));
        for (var theInterface:interfaces) {
            System.out.println(theInterface);
            System.out.println(theInterface.getSuperclass());
        }

    }
}
