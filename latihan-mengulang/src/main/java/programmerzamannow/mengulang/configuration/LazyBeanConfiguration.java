package programmerzamannow.mengulang.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;
import programmerzamannow.mengulang.data.Data;
import programmerzamannow.mengulang.data.DataFoo;
import programmerzamannow.mengulang.data.Foo;

@Configuration
public class LazyBeanConfiguration {

    @Bean
    public Data data(){
        return new Data();
    }

    @Bean
    public Foo foo(){
        return new Foo();
    }

    @Bean
    @Lazy
    public DataFoo dataFoo(Data data, Foo foo){
        return new DataFoo(data, foo);
    }
}
