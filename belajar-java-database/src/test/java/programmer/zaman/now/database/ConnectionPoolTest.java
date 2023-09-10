package programmer.zaman.now.database;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionPoolTest {

    @Test
    void testHikariCP() {
        HikariConfig config = new HikariConfig();
        config.setDriverClassName("com.mysql.cj.jdbc.Driver");
        config.setJdbcUrl("jdbc:mysql://localhost:3306/belajar_java_database");
        config.setUsername("root");
        config.setPassword("h3ndyganteng");

        config.setMaximumPoolSize(10);
        config.setMinimumIdle(5);
        config.setIdleTimeout(60000);
        config.setMaxLifetime(10 * 60000);

        try {
            HikariDataSource dataSource = new HikariDataSource(config);
            Connection connection = dataSource.getConnection();
            connection.close();
            System.out.println("sukses mengembalikan cenection");
            dataSource.close();
            System.out.println("sukses menutup pool");
        }catch (SQLException exception){
            Assertions.fail(exception);
        }
    }

    @Test
    void testUtil() {
        try {
            Connection connection = ConectionUtil.getDataSource().getConnection();
        }catch (SQLException exception){
            Assertions.fail(exception);
        }
    }
}
