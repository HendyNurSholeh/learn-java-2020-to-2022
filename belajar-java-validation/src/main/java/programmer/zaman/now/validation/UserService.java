package programmer.zaman.now.validation;

import jakarta.validation.constraints.NotBlank;
import programmer.zaman.now.validation.constraint.CheckPasswordParameter;

public class UserService {
    @CheckPasswordParameter(passwordParam = 1, retypePasswordParam = 2)
    public void register(
            @NotBlank(message = "parameter name must not blank") String name,
            @NotBlank(message = "parameter password must not blank") String password,
            @NotBlank(message = "parameter retype password must not blank") String retypePassword) {
        // bebass brooo
    }
}
