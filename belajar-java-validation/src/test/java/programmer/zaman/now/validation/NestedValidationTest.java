package programmer.zaman.now.validation;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

public class NestedValidationTest {

    private Validator validator;

    @BeforeEach
    void setUp() {
        validator = Validation.buildDefaultValidatorFactory().getValidator();
    }

    @Test
    void testNestedField() {
        var addres = new Address("Kaliantan Selatan", "kintap", "nur sehat");

        var person = new Person("hendy", "kanzawa");
        person.setAddress(addres);

        Set<ConstraintViolation<Person>> validate = validator.validate(person);
        for (var result:validate) {
            System.out.println("===========");
            System.out.println(result.getMessage());
            System.out.println(result.getPropertyPath());
        }

    }
}
