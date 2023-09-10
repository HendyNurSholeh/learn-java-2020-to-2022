package programmer.zaman.now.validation;

import jakarta.validation.ConstraintViolation;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.util.Set;

public class ConstructorValidationTest extends AbstractValidator{

    @Test
    void constructorTest() throws NoSuchMethodException {
        var person = new Person();
        person.setFirtsName("hendy");
        person.setLastName("ganteng");

        Constructor<? extends Person> constructor = person.getClass().getDeclaredConstructor();

        Set<ConstraintViolation<Person>> violations = executableValidator.validateConstructorReturnValue(constructor, person);
        for (var violation:violations) {
            System.out.println("======================");
            System.out.println(violation.getPropertyPath());
            System.out.println(violation.getMessage());
        }
    }

    @Test
    void constructorParameterTest() throws NoSuchMethodException {

        Constructor<? extends Person> constructor = Person.class.getDeclaredConstructor(String.class, String.class, Address.class);

        Set<ConstraintViolation<Person>> violations = executableValidator.
                validateConstructorParameters(constructor, new Object[]{"", "", new Address()});
        for (var violation:violations) {
            System.out.println("======================");
            System.out.println(violation.getPropertyPath());
            System.out.println(violation.getMessage());
        }
    }
}
