package programmerzamannow.mengulang.component;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import programmerzamannow.mengulang.data.Car;

@Configuration
public class CarComponent {

    @Bean
    public Car car(){
        return new Car();
    }
}
