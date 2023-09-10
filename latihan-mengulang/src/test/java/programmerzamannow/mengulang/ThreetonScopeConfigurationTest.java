package programmerzamannow.mengulang;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import programmerzamannow.mengulang.configuration.ThreetonScopeConfiguration;
import programmerzamannow.mengulang.data.Foo;


@Slf4j
public class ThreetonScopeConfigurationTest {

    private ApplicationContext applicationContext;

    @BeforeEach
    void setUp() {
        applicationContext = new AnnotationConfigApplicationContext(ThreetonScopeConfiguration.class);
    }

    @Test
    void testThreetonScope() {
        Foo foo1 = applicationContext.getBean(Foo.class);
        Foo foo2 = applicationContext.getBean(Foo.class);
        Foo foo3 = applicationContext.getBean(Foo.class);
        Foo foo4 = applicationContext.getBean(Foo.class);
        Foo foo5 = applicationContext.getBean(Foo.class);

        Assertions.assertNotSame(foo1, foo2);
        Assertions.assertNotSame(foo3, foo2);
        Assertions.assertSame(foo1, foo4);
        Assertions.assertSame(foo2, foo5);
        log.info(foo1.toString());
        log.info(foo2.toString());
        log.info(foo3.toString());
        log.info(foo4.toString());
        log.info(foo5.toString());
    }
}
