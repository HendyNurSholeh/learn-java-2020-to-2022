package programmerzamannow.mengulang.component;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import programmerzamannow.mengulang.data.CustomerRepository;

@Component
public class CustomerService {

    @Getter
    private CustomerRepository customerRepository;

    public CustomerService(@Qualifier(value = "memberCustomerRepository")CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }
}
