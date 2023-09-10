package programmer.zaman.now.database;

import org.junit.jupiter.api.Test;

import java.sql.*;

public class AutoIncrementTest {

    @Test
    void testAutoIncrement() throws SQLException {
        Connection connection = ConectionUtil.getDataSource().getConnection();
        Statement statement = connection.createStatement();

        String sql = "insert into comments (email, comment) values ('hendy@gmail.com', 'no sleep sebelum ngoding')";
        int update = statement.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);

        ResultSet resultSet = statement.getGeneratedKeys();
        if (resultSet.next()){
            String generateKey = resultSet.getString(1);
            System.out.println(generateKey);
        }

        resultSet.close();
        statement.close();
        connection.close();
    }

    @Test
    void testAutoIncrement2() throws SQLException {
        Connection connection = ConectionUtil.getDataSource().getConnection();
        String sql = """
                insert into comments (email, comment)
                values (?, ?)
                """;
        PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        preparedStatement.setString(1, "zoro@gmail.com");
        preparedStatement.setString(2, "pengguna pedang terhebat di land of down");

        int update = preparedStatement.executeUpdate();
        System.out.println("berhasil diupdate = " + update);

        ResultSet resultSet = preparedStatement.getGeneratedKeys();
        if (resultSet.next()){
            System.out.println(resultSet.getString(1));
        }

        resultSet.close();
        preparedStatement.close();
        connection.close();
    }
}
