package programmerzamannow.mengulang.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import programmerzamannow.mengulang.data.Data;
import programmerzamannow.mengulang.data.Foo;

@Configuration
public class DependsOnConfiguration {

    @Bean
    @DependsOn(value = "foo")
    public Data data(){
        return new Data();
    }

    @Bean
    public Foo foo(){
        return new Foo();
    }
}
