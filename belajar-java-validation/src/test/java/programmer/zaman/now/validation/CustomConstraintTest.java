package programmer.zaman.now.validation;

import org.junit.jupiter.api.Test;

import java.util.Locale;

public class CustomConstraintTest extends AbstractValidator{

    @Test
    void testConstraintCase() {
        var order = new Order();
        order.setId("Hai");
        order.setAmount(5000L);

        Locale.setDefault(new Locale("in", "ID"));
        validate(order);

    }
}
