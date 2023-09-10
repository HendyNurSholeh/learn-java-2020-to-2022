package programmerzamannow.mengulang.configuration;

import org.springframework.beans.factory.config.CustomScopeConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import programmerzamannow.mengulang.data.Data;
import programmerzamannow.mengulang.others.ThreetonScope;


@Configuration
public class DataConfiguration {

    @Bean(value = "data")
    @Scope("threetonScope")
    public Data data1(){
        return new Data();
    }

    @Bean
    public Data data2(){
        return new Data();
    }
}
