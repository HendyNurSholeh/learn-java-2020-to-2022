package programmer.zaman.now.validation;

import org.junit.jupiter.api.Test;
import programmer.zaman.now.validation.grups.payment.VirtualAccountPaymentGrup;

public class GroupConversionTest extends AbstractValidator {

    @Test
    void testPaymentWithCustomer() {
        var payment = new Payment();
        var customer = new Customer();
        customer.setName("hendy");
        customer.setEmail("hendy@gmail.com");

        payment.setOrderId("10");
        payment.setAmount(300000L);
        payment.setVirtualAccount("Gopay : 083142301830");
        payment.setCustomer(customer);

        validateWithGrup(payment, VirtualAccountPaymentGrup.class);
    }
}
