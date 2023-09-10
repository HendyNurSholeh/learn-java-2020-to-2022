package programmer.zaman.now.validation.grups.payment;

import jakarta.validation.GroupSequence;
import jakarta.validation.groups.Default;

@GroupSequence({
        CreditCardPaymentGrup.class,
        VirtualAccountPaymentGrup.class,
        Default.class})
public interface PaymentGroupSequence {
}
