package programmer.zaman.now.validation;

import org.junit.jupiter.api.Test;
import programmer.zaman.now.validation.grups.payment.CreditCardPaymentGrup;

public class PayloadTest extends AbstractValidator{

    @Test
    void testCardCreditNotInvalidFormat() {
        var payment = new Payment();
        payment.setOrderId("P0001");
        payment.setAmount(300000L);
        payment.setCreditCard("4111111111111111");
        payment.setVirtualAccount("083142301830");
        payment.setCustomer(new Customer("vincent", "vinent@gmail.com"));

        validateWithGrupAndPayment(payment, CreditCardPaymentGrup.class);
    }
}
