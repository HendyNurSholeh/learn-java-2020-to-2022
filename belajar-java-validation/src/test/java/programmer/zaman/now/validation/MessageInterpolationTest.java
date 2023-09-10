package programmer.zaman.now.validation;

import org.junit.jupiter.api.Test;

public class MessageInterpolationTest extends AbstractValidator{

    @Test
    void testOrder() {
        var order = new Order();
        order.setId("");
        order.setAmount(null);

        validate(order);
    }
}
