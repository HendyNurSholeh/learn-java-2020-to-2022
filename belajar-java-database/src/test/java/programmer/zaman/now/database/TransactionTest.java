package programmer.zaman.now.database;

import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TransactionTest {

    @Test
    void testCommit() throws SQLException {
        Connection connection = ConectionUtil.getDataSource().getConnection();
        connection.setAutoCommit(false);
        String sql = """
                insert into comments (email, comment)
                values (?, ?)
                """;
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, "zoro@gmail.com");
        preparedStatement.setString(2, "sang penguasa lautan HAHA");
        for (int i = 0; i < 50; i++) {
            preparedStatement.executeUpdate();
        }

        connection.commit();
        preparedStatement.close();
        connection.close();
    }

    @Test
    void testRollback() throws SQLException {
        Connection connection = ConectionUtil.getDataSource().getConnection();
        connection.setAutoCommit(false);
        String sql = """
                insert into comments (email, comment)
                values (?, ?)
                """;
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, "zoro@gmail.com");
        preparedStatement.setString(2, "sang penguasa lautan HAHA");
        for (int i = 0; i < 50; i++) {
            preparedStatement.  executeUpdate();
        }

        connection.rollback();
        preparedStatement.close();
        connection.close();
    }
}
