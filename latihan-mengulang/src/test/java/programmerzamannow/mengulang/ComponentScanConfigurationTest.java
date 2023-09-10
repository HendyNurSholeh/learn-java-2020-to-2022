package programmerzamannow.mengulang;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import programmerzamannow.mengulang.configuration.ComponentScanConfiguration;
import programmerzamannow.mengulang.data.Data;

public class ComponentScanConfigurationTest {
    
    ConfigurableApplicationContext applicationContext;

    @BeforeEach
    void setUp() {
        applicationContext = new AnnotationConfigApplicationContext(ComponentScanConfiguration.class);
        applicationContext.registerShutdownHook();
    }

    @Test
    void testComponentScan() {
        Data data = applicationContext.getBean(Data.class);

    }
}
