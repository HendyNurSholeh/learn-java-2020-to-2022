package programmer.zaman.now.validation.constraint;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import jakarta.validation.constraintvalidation.SupportedValidationTarget;
import jakarta.validation.constraintvalidation.ValidationTarget;

@SupportedValidationTarget({ValidationTarget.PARAMETERS})
public class CheckPasswordParameterValidator implements ConstraintValidator<CheckPasswordParameter, Object[]> {


    private int passwordParam;

    private int retypePasswordParam;

    @Override
    public void initialize(CheckPasswordParameter constraintAnnotation) {
        this.passwordParam = constraintAnnotation.passwordParam();
        this.retypePasswordParam = constraintAnnotation.retypePasswordParam();
    }

    @Override
    public boolean isValid(Object[] objects, ConstraintValidatorContext constraintValidatorContext) {
        Object passwordParamValue = objects[this.passwordParam];
        Object retypePasswordParamValue = objects[this.retypePasswordParam];
        if(passwordParamValue == null || retypePasswordParamValue == null){
            return true; // skip validation
        }
        return passwordParamValue.equals(retypePasswordParamValue);
    }
}
