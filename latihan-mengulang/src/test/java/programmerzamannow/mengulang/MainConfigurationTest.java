package programmerzamannow.mengulang;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import programmerzamannow.mengulang.configuration.MainConfiguration;
import programmerzamannow.mengulang.data.Data;
import programmerzamannow.mengulang.data.Foo;

public class MainConfigurationTest {

    ConfigurableApplicationContext applicationContext;

    @BeforeEach
    void setUp() {
        applicationContext = new AnnotationConfigApplicationContext(MainConfiguration.class);
        applicationContext.registerShutdownHook();
    }

    @Test
    void testImport() {
        Data data1 = applicationContext.getBean("data", Data.class);
        Data data2 = applicationContext.getBean("data", Data.class);
        Data data3 = applicationContext.getBean("data", Data.class);
        Data data4 = applicationContext.getBean("data", Data.class);
        Data data5 = applicationContext.getBean("data", Data.class);
        Foo foo1 = applicationContext.getBean("foo1", Foo.class);
        Foo foo2 = applicationContext.getBean("foo1", Foo.class);
        Foo foo3 = applicationContext.getBean("foo1", Foo.class);

        Assertions.assertNotSame(data1, data2);
        Assertions.assertNotSame(data3, data2);
        Assertions.assertSame(data4, data1);
        Assertions.assertSame(data5, data2);
        Assertions.assertSame(foo1, foo2);
        Assertions.assertSame(foo2, foo3);
    }
}
