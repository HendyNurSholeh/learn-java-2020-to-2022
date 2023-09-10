package programmer.zaman.now.validation;

import jakarta.validation.constraints.NotBlank;
import programmer.zaman.now.validation.constraint.CheckPassword;

@CheckPassword(message = "{register.checkpassword}")
public class Register {

    public Register() {
    }

    public Register(String name, String password, String retypePassword) {
        this.name = name;
        this.password = password;
        this.retypePassword = retypePassword;
    }

    @NotBlank(message = "name must be not blank")
    private String name;

    @NotBlank(message = "password must be not blank")
    private String password;

    @NotBlank(message = "retype password must be not blank")
    private String retypePassword;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRetypePassword() {
        return retypePassword;
    }

    public void setRetypePassword(String retypePassword) {
        this.retypePassword = retypePassword;
    }
}
