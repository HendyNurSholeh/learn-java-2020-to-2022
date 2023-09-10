package programmer.zaman.now.validation;

import jakarta.validation.groups.Default;
import org.junit.jupiter.api.Test;
import programmer.zaman.now.validation.grups.payment.CreditCardPaymentGrup;
import programmer.zaman.now.validation.grups.payment.VirtualAccountPaymentGrup;

public class GrupConstraintTest extends AbstractValidator{

    @Test
    void testPaymentVirtualAccountPaymentGrup() {
        var payment = new Payment();
        validateWithGrup(payment, VirtualAccountPaymentGrup.class);
    }

    @Test
    void testPaymentCreditCardPaymentGrup() {
        var payment = new Payment();
        validateWithGrup(payment, CreditCardPaymentGrup.class);
    }

    @Test
    void testPaymentDefaultGrup() {
        var payment = new Payment();
        validateWithGrup(payment, Default.class);
        // or
        var payment2 = new Payment();
        validateWithGrup(payment2);
    }
}
