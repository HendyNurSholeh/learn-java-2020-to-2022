package programmer.zaman.now;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import programmer.zaman.now.utility.ConnectorUtil;

import java.sql.Connection;
import java.sql.SQLException;

public class ConnectorUtilTest {

    @Test
    void testkoneksiKeDatabase(){
        try {
            Connection connection = ConnectorUtil.getDataSource().getConnection();
            System.out.println("sukses koneksi");
            connection.close();
        }catch (SQLException exception){
            Assertions.fail(exception);
        }
    }
}
