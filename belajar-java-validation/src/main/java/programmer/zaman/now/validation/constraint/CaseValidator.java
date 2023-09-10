package programmer.zaman.now.validation.constraint;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class CaseValidator implements ConstraintValidator<Case, String> {

    boolean allowCaseUppper;

    @Override
    public void initialize(Case constraintAnnotation) {
        this.allowCaseUppper = constraintAnnotation.allowCaseUpper();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
        if (value == null) return true; // skip validation if value is null

        if (allowCaseUppper){
            return value.equals(value.toUpperCase());
        } else {
            return value.equals(value.toLowerCase());
        }

    }
}
