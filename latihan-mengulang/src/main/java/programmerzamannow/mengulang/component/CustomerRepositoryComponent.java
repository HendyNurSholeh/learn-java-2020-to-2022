package programmerzamannow.mengulang.component;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import programmerzamannow.mengulang.data.CustomerRepository;

@Configuration
public class CustomerRepositoryComponent {

    @Bean
    @Primary
    public CustomerRepository normalCustomerRepository(){
        return new CustomerRepository();
    }

    @Bean
    public CustomerRepository memberCustomerRepository(){
        return new CustomerRepository();
    }

}
