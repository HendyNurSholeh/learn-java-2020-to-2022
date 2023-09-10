package programmerzamannow.mengulang.configuration;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import programmerzamannow.mengulang.data.Data;
import programmerzamannow.mengulang.data.DataFoo;
import programmerzamannow.mengulang.data.Foo;

@Configuration
public class DependencyInjectionConfiguration {

    @Bean
    @Primary
    public Data dataPrimary(){
        return new Data();
    }

    @Bean
    @Primary
    public Foo foo(){
        return new Foo();
    }

    @Bean
    public Foo foo2(){
        return new Foo();
    }

    @Bean
    public DataFoo dataFoo(Data data, @Qualifier("foo2") Foo foo){
        return new DataFoo(data, foo);
    }
}
