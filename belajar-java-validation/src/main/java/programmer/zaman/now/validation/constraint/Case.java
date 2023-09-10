package programmer.zaman.now.validation.constraint;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(
        validatedBy = {CaseValidator.class}
)
@Target({ElementType.FIELD, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface Case {

    boolean allowCaseUpper() default false;

    String message() default "case value is not format";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
