package programmerzamannow.mengulang.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import programmerzamannow.mengulang.others.ConnectionDatabase;

@Configuration
public class ConnectionDatabaseConfiguration {

    @Bean
    public ConnectionDatabase connectionDatabase() {
        return new ConnectionDatabase();
    }
}
