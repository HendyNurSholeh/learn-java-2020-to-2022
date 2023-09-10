package programmer.zaman.now.validation;

import jakarta.validation.ConstraintViolation;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;
import java.util.Set;

public class CrossParameterConstraintTest extends AbstractValidator{

    @Test
    void checkPasswordParameter() throws NoSuchMethodException {
        UserService userService = new UserService();
        Method register = UserService.class.getDeclaredMethod("register", String.class, String.class, String.class);

        Set<ConstraintViolation<UserService>> violations = executableValidator
                .validateParameters(userService, register, new Object[]{"hendy", "hendy123", "hendY123"});
        for (var violation:violations) {
            System.out.println("==================");
            System.out.println(violation.getPropertyPath());
            System.out.println(violation.getMessage());
        }
    }
}
