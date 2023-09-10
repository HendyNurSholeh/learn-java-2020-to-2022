package programmerzamannow.mengulang;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import programmerzamannow.mengulang.configuration.CircularDependenciesConfiguration;

import java.util.ArrayList;
import java.util.List;

public class CircularDependenciesConfigurationTest {

    ApplicationContext applicationContext;

    @BeforeEach
    void setUp() {
        applicationContext = new AnnotationConfigApplicationContext(CircularDependenciesConfiguration.class);
    }

}
