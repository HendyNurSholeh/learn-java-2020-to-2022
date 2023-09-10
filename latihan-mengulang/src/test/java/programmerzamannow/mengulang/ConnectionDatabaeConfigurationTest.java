package programmerzamannow.mengulang;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import programmerzamannow.mengulang.configuration.ConnectionDatabaseConfiguration;

public class ConnectionDatabaeConfigurationTest {

    private ConfigurableApplicationContext applicationContext;

    @BeforeEach
    void setUp() {
        applicationContext = new AnnotationConfigApplicationContext(ConnectionDatabaseConfiguration.class);
        applicationContext.registerShutdownHook();
    }

    @Test
    void testConnection() {

    }
}
