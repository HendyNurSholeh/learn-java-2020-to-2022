package programmer.zaman.now.validation;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import org.junit.jupiter.api.Test;

import java.util.Set;

public class ExceptionViolationTest extends AbstractValidator {

    @Test
    void testException() {
        var person = new Person();

        Set<ConstraintViolation<Person>> violations = validator.validate(person);
        if (!violations.isEmpty()){
            throw new ConstraintViolationException(violations);
        }
    }
}
