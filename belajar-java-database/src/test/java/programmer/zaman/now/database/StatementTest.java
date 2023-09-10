package programmer.zaman.now.database;

import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class StatementTest {

    @Test
    void testCreateStatement() throws SQLException {
        Connection connection = ConectionUtil.getDataSource().getConnection();
        Statement statement = connection.createStatement();

        connection.close();
        statement.close();
    }

    @Test
    void testExecuteUpdate() throws SQLException {
        Connection connection = ConectionUtil.getDataSource().getConnection();
        Statement statement = connection.createStatement();

        String sql = """
                insert into customers(id, name, email)
                values ('kurniawan', 'Kurniawan', 'kurniawan@gmail.com')
                """;

        int update = statement.executeUpdate(sql);
        System.out.println(update);

        connection.close();
        statement.close();
    }

    @Test
    void testExecuteDelete() throws SQLException {
        Connection connection = ConectionUtil.getDataSource().getConnection();
        Statement statement = connection.createStatement();

        String sql = "delete from customers";

        int update = statement.executeUpdate(sql);
        System.out.println(update);

        connection.close();
        statement.close();
    }

    @Test
    void testExecuteQuery() throws SQLException {
        Connection connection = ConectionUtil.getDataSource().getConnection();
        Statement statement = connection.createStatement();

        String sql = "select * from customers";

        ResultSet resultSet = statement.executeQuery(sql);

        resultSet.close();
        connection.close();
        statement.close();
    }
}
