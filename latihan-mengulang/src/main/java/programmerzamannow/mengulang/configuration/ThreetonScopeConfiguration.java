package programmerzamannow.mengulang.configuration;

import org.springframework.beans.factory.config.CustomScopeConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import programmerzamannow.mengulang.data.Foo;
import programmerzamannow.mengulang.others.ThreetonScope;

@Configuration
public class ThreetonScopeConfiguration {

    @Bean
    public CustomScopeConfigurer customScopeConfigurer(){
        CustomScopeConfigurer configurer = new CustomScopeConfigurer();
        configurer.addScope("threetonScope", new ThreetonScope());
        return configurer;
    }

    @Bean
    @Scope()
    public Foo foo1(){
        return new Foo();
    }
}
