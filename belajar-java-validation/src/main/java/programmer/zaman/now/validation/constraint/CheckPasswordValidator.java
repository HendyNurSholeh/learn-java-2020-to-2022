package programmer.zaman.now.validation.constraint;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import programmer.zaman.now.validation.Register;

public class CheckPasswordValidator implements ConstraintValidator<CheckPassword, Register> {

    String message;

    @Override
    public void initialize(CheckPassword constraintAnnotation) {
        message = constraintAnnotation.message();
    }

    @Override
    public boolean isValid(Register register, ConstraintValidatorContext constraintValidatorContext) {
        if (register.getPassword() == null || register.getRetypePassword()==null){
            return true;
        }
        boolean equals = register.getPassword().equals(register.getRetypePassword());

        if (!equals){
            constraintValidatorContext.disableDefaultConstraintViolation();
            constraintValidatorContext.buildConstraintViolationWithTemplate(message)
                    .addPropertyNode("Register.password & Register.retypePassword")
                    .addConstraintViolation();
        }

        return equals;
    }
}
