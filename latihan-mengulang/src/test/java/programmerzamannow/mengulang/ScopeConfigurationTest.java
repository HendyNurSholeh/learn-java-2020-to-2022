package programmerzamannow.mengulang;

import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import programmerzamannow.mengulang.configuration.ScopeConfiguration;
import programmerzamannow.mengulang.data.Data;
import programmerzamannow.mengulang.data.Foo;

@Slf4j
public class ScopeConfigurationTest {

    private ApplicationContext applicationContext;

    @BeforeEach
    void setUp() {
        applicationContext = new AnnotationConfigApplicationContext(ScopeConfiguration.class);
    }

    @Test
    void testScopePrototype() {
        Data data1 = applicationContext.getBean(Data.class);
        Data data2 = applicationContext.getBean(Data.class);
        Data data3 = applicationContext.getBean(Data.class);
        Assertions.assertSame(data1, data2);
        Assertions.assertSame(data3, data2);
        log.info("------------Data--------");
        log.info(data1 + " : " + data2 + " : " + data3);

        Foo foo1 = applicationContext.getBean(Foo.class);
        Foo foo2 = applicationContext.getBean(Foo.class);
        Foo foo3 = applicationContext.getBean(Foo.class);
        Assertions.assertNotSame(foo1, foo2);
        Assertions.assertNotSame(foo3, foo2);
        log.info("------------Foo--------");
        log.info(foo1 + " : " + foo2 + " : " + foo3);
    }
}
