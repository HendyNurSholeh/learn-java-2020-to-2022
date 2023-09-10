package programmer.zaman.now.validation;

import jakarta.validation.Validator;
import org.junit.jupiter.api.Test;

public class HibernateValidatorConstraintTest extends AbstractValidator {

    @Test
    void testPayment() {
        var payment = new Payment();
        payment.setOrderId("P0001");
        payment.setAmount(10000L);
        payment.setCreditCard("4111111111111111");
        validate(payment);
    }
}
