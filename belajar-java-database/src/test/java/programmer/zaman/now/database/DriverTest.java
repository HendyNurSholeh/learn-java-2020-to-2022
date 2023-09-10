package programmer.zaman.now.database;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DriverTest {

    @Test
    void testRegister() {
        try {
            Driver msqlDriver = new com.mysql.cj.jdbc.Driver();
            DriverManager.registerDriver(msqlDriver);

        }catch (SQLException exception){
            Assertions.fail(exception);
        }
    }
}
