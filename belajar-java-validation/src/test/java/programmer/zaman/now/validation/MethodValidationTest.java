package programmer.zaman.now.validation;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Valid;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;
import java.util.Set;

public class MethodValidationTest extends AbstractValidator {

    @Test
    void testMethodParameters() throws NoSuchMethodException {
        var person = new Person();

        Method sayHello = person.getClass().getDeclaredMethod("sayHello", String.class);

        Set<ConstraintViolation<Person>> violations = executableValidator.validateParameters(person, sayHello, new Object[]{"hendy ganteng"});
        for (var violation:violations) {
            System.out.println("===============");
            System.out.println(violation.getPropertyPath());
            System.out.println(violation.getMessage());
        }

    }

    @Test
    void testMethodReturnValue() throws NoSuchMethodException {
        var person = new Person();
        person.setFirtsName("   ");
        person.setLastName(" sholeh");
        String fullNameReturnValue = person.fullName();

        Method fullName = person.getClass().getDeclaredMethod("fullName");

        Set<ConstraintViolation<Person>> violations = executableValidator.validateReturnValue(person, fullName, fullNameReturnValue);
        for (var violation:violations) {
            System.out.println("===============");
            System.out.println(violation.getPropertyPath());
            System.out.println(violation.getMessage());
        }

    }
}
