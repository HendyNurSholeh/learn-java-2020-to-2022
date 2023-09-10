package programmer.zaman.now.validation.constraint;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import jakarta.validation.ReportAsSingleViolation;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.lang.annotation.*;


@Documented
@Constraint(
        validatedBy = {}
)
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
// annotation check order id
@Case(allowCaseUpper = true, message = "{order.id.case}")
@NotBlank(message = "{order.id.notblank}")
@Size(min = 1, max = 10, message = "{order.id.size}")
@ReportAsSingleViolation
public @interface CheckOrderId {

    String message() default "order id is not correct";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
