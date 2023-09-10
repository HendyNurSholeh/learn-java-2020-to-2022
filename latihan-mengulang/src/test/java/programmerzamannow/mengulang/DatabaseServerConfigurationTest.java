package programmerzamannow.mengulang;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import programmerzamannow.mengulang.configuration.DatabaseServerConfiguration;

public class DatabaseServerConfigurationTest {

    ConfigurableApplicationContext applicationContext;

    @BeforeEach
    void setUp() {
        applicationContext = new AnnotationConfigApplicationContext(DatabaseServerConfiguration.class);
        applicationContext.close();
    }

    @Test
    void testInitAndDestroyWithBean() {

    }
}
