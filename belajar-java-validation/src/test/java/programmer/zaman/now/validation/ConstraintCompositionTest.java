package programmer.zaman.now.validation;

import org.junit.jupiter.api.Test;

public class ConstraintCompositionTest extends AbstractValidator {

    @Test
    void testAnnotationCheckOrderId() {
        var order = new Order();
        order.setId("");
        order.setAmount(5000L);

        validate(order);
    }
}
