package programmer.zaman.now.database;

import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SqlInjectionTest {

    @Test
    void testSqlInjection() throws SQLException {
        Connection connection = ConectionUtil.getDataSource().getConnection();
        Statement statement = connection.createStatement();

        String username = "hendy'#";
        String password = "salah";
        String sql = "select * from admin where username = '"
                      + username + "' and password = '" + password + "'";

        ResultSet resultSet = statement.executeQuery(sql);

        if (resultSet.next()){
            System.out.println("login sukses");
            System.out.println("username : " + resultSet.getString("username"));
        }else {
            System.out.println("login gagal");
        }

        resultSet.close();
        connection.close();
        statement.close();
    }
}
