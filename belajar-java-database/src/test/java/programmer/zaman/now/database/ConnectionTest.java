package programmer.zaman.now.database;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionTest {

    @BeforeAll
    static void beforeAll() {
        try {
            Driver msqlDriver = new com.mysql.cj.jdbc.Driver();
            DriverManager.registerDriver(msqlDriver);
        }catch (SQLException exception){
            exception.printStackTrace();
        }
    }

    @Test
    void testConnection() {
        String jdbcUrl = "jdbc:mysql://localhost:3306/belajar_java_database";
        String userName = "root";
        String password = "h3ndyganteng";
        try {
            Connection connection = DriverManager.getConnection(jdbcUrl, userName, password);
            System.out.println("sukses konek ke database");
        }catch (SQLException exception){
            Assertions.fail(exception);
        }
    }

    @Test
    void testConnectionClose() {
        String jdbcUrl = "jdbc:mysql://localhost:3306/belajar_java_database";
        String userName = "root";
        String password = "h3ndyganteng";

        try (Connection connection = DriverManager.getConnection(jdbcUrl, userName, password)){
            System.out.println("sukses konek ke database");
        }catch (SQLException exception){
            Assertions.fail(exception);
        }
    }
}
