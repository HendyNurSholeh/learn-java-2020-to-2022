package programmer.zaman.now.validation;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Set;

public class ValidationTest {

    @Test
    void testCreateValidator() {
        var validation = new Validation();
        ValidatorFactory validatorFactory = validation.buildDefaultValidatorFactory();
        Validator validator = validatorFactory.getValidator();

        Assertions.assertNotNull(validator);
        validatorFactory.close();
    }

}
