package programmer.zaman.now.validation;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.groups.ConvertGroup;
import jakarta.validation.groups.Default;
import org.hibernate.validator.constraints.CreditCardNumber;
import org.hibernate.validator.constraints.LuhnCheck;
import org.hibernate.validator.constraints.Range;
import programmer.zaman.now.validation.constraint.CheckPassword;
import programmer.zaman.now.validation.grups.payment.CreditCardPaymentGrup;
import programmer.zaman.now.validation.grups.payment.VirtualAccountPaymentGrup;
import programmer.zaman.now.validation.payload.SendMessageErrorPayload;

public class Payment {

    @ConvertGroup(from = CreditCardPaymentGrup.class, to = Default.class)
    @ConvertGroup(from = VirtualAccountPaymentGrup.class, to = Default.class)
    @Valid
    @NotNull(groups = {CreditCardPaymentGrup.class, VirtualAccountPaymentGrup.class}, message = "Customer must be not null")
    private Customer customer;

    @NotBlank(groups = {CreditCardPaymentGrup.class, VirtualAccountPaymentGrup.class}, message = "Order Id cannot null or blank/empty")
    private String orderId;

    @Range(groups = {CreditCardPaymentGrup.class, VirtualAccountPaymentGrup.class}, min = 10000L, max = 50000000L, message = "Range must be 10k - 500000k")
    @NotNull(groups = {CreditCardPaymentGrup.class, VirtualAccountPaymentGrup.class}, message = "Amount Cannot is null")
    private Long amount;

    @LuhnCheck(payload = SendMessageErrorPayload.class, groups = CreditCardPaymentGrup.class, message = "Credit Card is false")
    @CreditCardNumber(payload = SendMessageErrorPayload.class, groups = CreditCardPaymentGrup.class, message = "Credit Card is not correct")
    @NotBlank(groups = CreditCardPaymentGrup.class, message = "Credit Card cannot null or blank/empty")
    private String creditCard;

    @NotBlank(groups = VirtualAccountPaymentGrup.class, message = "Virtual Account cannot null or blank/empty")
    private String virtualAccount;

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getVirtualAccount() {
        return virtualAccount;
    }

    public void setVirtualAccount(String virtualAccount) {
        this.virtualAccount = virtualAccount;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public String getCreditCard() {
        return creditCard;
    }

    public void setCreditCard(String creditCard) {
        this.creditCard = creditCard;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "customer=" + customer +
                ", orderId='" + orderId + '\'' +
                ", amount=" + amount +
                ", creditCard='" + creditCard + '\'' +
                ", virtualAccount='" + virtualAccount + '\'' +
                '}';
    }
}
