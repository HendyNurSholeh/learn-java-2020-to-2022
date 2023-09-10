package programmer.zaman.now.database;

import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PrepareStatementTest {

    @Test
    void testPrepareStaetement() throws SQLException {
        Connection connection = ConectionUtil.getDataSource().getConnection();

        String username = "hendy";
        String password = "hendy";
        String sql = "select * from admin where username = ? and password = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, username);
        preparedStatement.setString(2, password);

        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()){
            System.out.println("Berhasil login : " + resultSet.getString("username"));
        }else {
            System.out.println("Gagal login, username atau password salah");
        }

        resultSet.close();
        preparedStatement.close();
        connection.close();
    }
}
