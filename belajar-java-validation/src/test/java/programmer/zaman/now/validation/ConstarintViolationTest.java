package programmer.zaman.now.validation;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import jakarta.validation.constraints.NotEmpty;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Set;

public class ConstarintViolationTest {

    private static Validator validator;
    private static ValidatorFactory validatorFactory;

    @BeforeAll
    static void beforeAll() {
        validatorFactory = Validation.buildDefaultValidatorFactory();
        validator = validatorFactory.getValidator();
    }

    @AfterAll
    static void afterAll() {
        validatorFactory.close();
    }

    @Test
    void testPersonValidatorFalse() {
        var person = new Person(null, "ini lebih dari sepuluh caracter");
        Set<ConstraintViolation<Object>> validate = validator.validate(person);
        Assertions.assertEquals(2, validate.size());
        for (var constrainViolation : validate) {
            System.out.println(constrainViolation.getMessage());
            System.out.println(constrainViolation.getLeafBean());
            System.out.println(constrainViolation.getConstraintDescriptor().getAnnotation());
            System.out.println(constrainViolation.getInvalidValue());
            constrainViolation.getPropertyPath().forEach(value -> System.out.println(value));
            System.out.println("=================");
        }
    }

    @Test
    void testPersonValidatorSuccess() {
        var person = new Person("hendy", "  ");
        Set<ConstraintViolation<Object>> validate = validator.validate(person);
        Assertions.assertEquals(0, validate.size());
        Assertions.assertTrue(validate.isEmpty());
        for (var constrainViolation : validate) {
            System.out.println(constrainViolation.getMessage());
            System.out.println("=================");
        }
    }
}
