package programmerzamannow.mengulang;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import programmerzamannow.mengulang.configuration.DataConfiguration;
import programmerzamannow.mengulang.data.Data;

@Slf4j
public class DataConfigurationTest {

    private ApplicationContext applicationContext;

    @BeforeEach
    void setUp() {
         applicationContext = new AnnotationConfigApplicationContext(DataConfiguration.class);
    }

    @Test
    void createBean() {
        var bean1 = applicationContext.getBean("dataPrimary", Data.class);
        Data bean2 = applicationContext.getBean(Data.class);
        Assertions.assertSame(bean1, bean2);
        log.info(bean1 + " : " + bean2);
    }

    @Test
    void createDuplicateBean() {
        Data data1 = applicationContext.getBean("dataPrimary", Data.class);
        Data data2 = applicationContext.getBean("data2", Data.class);
        Assertions.assertNotSame(data1, data2);
        log.info(data1 + " : " + data2);
    }

    @Test
    void duplicateBeanWithPrimary() {
        Data bean1 = applicationContext.getBean(Data.class);
        Data bean2 = applicationContext.getBean(Data.class);
        Assertions.assertSame(bean1, bean2);
    }
}
