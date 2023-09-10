package programmerzamannow.mengulang.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import programmerzamannow.mengulang.others.DatabaseServer;

@Configuration
public class DatabaseServerConfiguration {

    @Bean(initMethod = "start", destroyMethod = "stop")
    public DatabaseServer databaseServer(){
        return new DatabaseServer();
    }
}
