package hyns;

import com.zaxxer.hikari.HikariDataSource;
import hyns.utility.ConnectorUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.SQLException;

public class ConnectorUtilTest {

    @Test
    void testKoneksi() {
        try{
            Connection connection = ConnectorUtil.getDataSource().getConnection();
            System.out.println("sukses terkoneksi");
            connection.close();
        }catch (SQLException e){
            Assertions.fail(e);
        }
    }
}
