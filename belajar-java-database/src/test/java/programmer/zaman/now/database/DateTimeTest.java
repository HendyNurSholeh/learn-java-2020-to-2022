package programmer.zaman.now.database;

import org.junit.jupiter.api.Test;

import java.sql.*;

public class DateTimeTest {

    @Test
    void testDateStatement() throws SQLException {
        Connection connection = ConectionUtil.getDataSource().getConnection();
        String sql = """
                insert into sample_date(sample_time, sample_date, sample_timestamp)
                values(?, ?, ?);                
                """;

        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setTime(1, new Time(System.currentTimeMillis()));
        preparedStatement.setDate(2, new Date(System.currentTimeMillis()));
        preparedStatement.setTimestamp(3, new Timestamp(System.currentTimeMillis()));

        int update = preparedStatement.executeUpdate();
        System.out.println(update);

        preparedStatement.close();
        connection.close();
    }

    @Test
    void testDateQuery() throws SQLException {
        Connection connection = ConectionUtil.getDataSource().getConnection();
        Statement statement = connection.createStatement();
        String sql = """
                select * from sample_date
                """;
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()){
            Time sample_time = resultSet.getTime("sample_time");
            Date sample_date = resultSet.getDate("sample_date");
            Timestamp sample_timestamp = resultSet.getTimestamp("sample_timestamp");

            System.out.println("time      : " + sample_time);
            System.out.println("date      : " + sample_date);
            System.out.println("timestamp : " + sample_timestamp);
        }
        resultSet.close();
        statement.close();
        connection.close();


    }
}
