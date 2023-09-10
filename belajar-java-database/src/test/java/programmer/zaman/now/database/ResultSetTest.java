package programmer.zaman.now.database;

import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ResultSetTest {

    @Test
    void testExecuteQuery() throws SQLException {
        Connection connection = ConectionUtil.getDataSource().getConnection();
        Statement statement = connection.createStatement();

        String sql = "select * from customers";

        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()){
            String id = resultSet.getString("id");
            String name = resultSet.getString(2);
            String email = resultSet.getString(3);

            System.out.println("\nid    : " + id);
            System.out.println("name  : " + name);
            System.out.println("email : " + email);
        }

        resultSet.close();
        connection.close();
        statement.close();
    }
}
