package programmer.zaman.now.validation.constraint;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(
        validatedBy = {CheckPasswordParameterValidator.class}
)
@Target({ElementType.FIELD, ElementType.ANNOTATION_TYPE, ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface CheckPasswordParameter {

    int passwordParam();

    int retypePasswordParam();

    String message() default "password and retype password must be same";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
