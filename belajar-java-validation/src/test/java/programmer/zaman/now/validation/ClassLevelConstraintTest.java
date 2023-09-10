package programmer.zaman.now.validation;

import org.junit.jupiter.api.Test;

import java.util.Locale;

public class ClassLevelConstraintTest extends AbstractValidator{

    @Test
    void testRegister() {
        Locale.setDefault(new Locale("in", "ID"));
        var register = new Register("hendy", "hendy123", "Hendy123");
        validate(register);
    }
}
