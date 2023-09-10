package programmerzamannow.mengulang;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import programmerzamannow.mengulang.configuration.DependencyInjectionConfiguration;
import programmerzamannow.mengulang.data.DataFoo;
import programmerzamannow.mengulang.data.Foo;

public class DependencyInjectionConfigurationTest {

    private ApplicationContext applicationContext;

    @BeforeEach
    void setUp() {
        applicationContext = new AnnotationConfigApplicationContext(DependencyInjectionConfiguration.class);
    }

    @Test
    void dependencyInjectionDataFoo() {
        Foo foo = applicationContext.getBean(Foo.class);
        DataFoo dataFoo = applicationContext.getBean(DataFoo.class);
        Assertions.assertNotSame(foo, dataFoo.getFoo());
    }
}
