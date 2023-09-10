package hyns.listbook.utility;

import hyns.listbook.entity.Books;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;

import java.util.Set;

public class ValidationUtil {

    private static ValidatorFactory validatorFactory;
    private static Validator validator;

    static {
        validatorFactory = Validation.buildDefaultValidatorFactory();
        validator = validatorFactory.getValidator();
    }

    public static boolean validate(Books book, String message){
        Set<ConstraintViolation<Books>> violations = validator.validate(book);
        if (!violations.isEmpty()){
            System.out.println(message);
            violations.stream().findFirst().ifPresent(value -> System.out.println(value.getMessage()));
        }
        return violations.isEmpty();
    }
}
