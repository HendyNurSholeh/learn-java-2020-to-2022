package programmerzamannow.mengulang;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import programmerzamannow.mengulang.configuration.LazyBeanConfiguration;
import programmerzamannow.mengulang.data.DataFoo;

@Slf4j
public class LazyBeanConfigurationTest {

    private ApplicationContext applicationContext;

    @BeforeEach
    void setUp() {
        applicationContext = new AnnotationConfigApplicationContext(LazyBeanConfiguration.class);
    }

    @Test
    void testLazyBean() {
        // baru dibuat
        log.info("Object DataFoo dibuat");
        DataFoo dataFoo = applicationContext.getBean(DataFoo.class);
        Assertions.assertNotNull(dataFoo);
    }
}
