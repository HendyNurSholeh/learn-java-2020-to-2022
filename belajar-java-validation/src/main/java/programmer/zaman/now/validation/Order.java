package programmer.zaman.now.validation;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.Range;
import programmer.zaman.now.validation.constraint.Case;
import programmer.zaman.now.validation.constraint.CheckOrderId;

public class Order {

    @CheckOrderId(message = "{order.id.checkorderid}")
    private String id;

    @NotNull(message = "{order.amount.notnull}")
    @Range(min = 10000, max = 100000, message = "{order.amount.range}")
    private Long amount;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }
}
