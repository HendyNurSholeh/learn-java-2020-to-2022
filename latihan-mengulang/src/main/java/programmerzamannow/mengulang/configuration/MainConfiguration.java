package programmerzamannow.mengulang.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({DependencyInjectionConfiguration.class, DataConfiguration.class, ThreetonScopeConfiguration.class})
public class MainConfiguration {
}
