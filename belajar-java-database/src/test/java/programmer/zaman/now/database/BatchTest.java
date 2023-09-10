package programmer.zaman.now.database;

import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;


public class BatchTest {
    @Test
    void testStatement() throws SQLException {
        Connection connection = ConectionUtil.getDataSource().getConnection();
        Statement statement = connection.createStatement();

        String sql = """
                insert into comments (email, comment) 
                values ('hendy@gmail.com', 'hehe')
                """;

        for (int i = 0; i < 100; i++) {
            statement.executeUpdate(sql);
        }

        connection.close();
        statement.close();
    }

    @Test
    void testPreparedStatement() throws SQLException {
        Connection connection = ConectionUtil.getDataSource().getConnection();

        String sql = """
                insert into comments (email, comment) 
                values (?, ?)
                """;
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        for (int i = 0; i < 100; i++) {
            preparedStatement.clearParameters();
            preparedStatement.setString(1, "excalibor@gmail.com");
            preparedStatement.setString(2, "ngebor");
            preparedStatement.addBatch();
        }

        preparedStatement.executeBatch();

        preparedStatement.close();
        connection.close();
    }
}
