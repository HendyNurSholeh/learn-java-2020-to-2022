package programmerzamannow.mengulang.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import programmerzamannow.mengulang.data.Data;
import programmerzamannow.mengulang.data.Foo;

@Configuration
public class ScopeConfiguration {

    @Bean
    public Data data(){
        return new Data();
    }

    @Bean
    @Scope(value = "prototype")
    public Foo foo(){
        return new Foo();
    }
}
