package programmerzamannow.mengulang.component;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import programmerzamannow.mengulang.data.Foo;

@Configuration
public class Foos {

    @Bean
    @Primary
    public Foo foo1(){
        return new Foo();
    }

    @Bean
    public Foo foo2(){
        return new Foo();
    }
}
