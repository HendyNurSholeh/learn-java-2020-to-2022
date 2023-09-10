package programmer.zaman.now.database;

import org.junit.jupiter.api.Test;

import java.sql.*;

public class MetaDataTest {

    @Test
    void testDatabaseMetaData() throws SQLException {
        Connection connection = ConectionUtil.getDataSource().getConnection();
        DatabaseMetaData metaData = connection.getMetaData();

        String productName = metaData.getDatabaseProductName();
        String productVersion = metaData.getDatabaseProductVersion();
        System.out.println(productName);
        System.out.println(productVersion);
        ResultSet resultSet = metaData.getTables("belajar_java_database", null, null, null);
        while (resultSet.next()){
            System.out.println(resultSet.getString("table_name"));
        }

        resultSet.close();
        connection.close();
    }

    @Test
    void testParameterMetaData() throws SQLException {
        Connection connection = ConectionUtil.getDataSource().getConnection();
        String sql = """
                insert into comments (email, comment)
                values (?, ?)
                """;
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ParameterMetaData parameterMetaData = preparedStatement.getParameterMetaData();

        System.out.println(parameterMetaData.getParameterCount());
//        System.out.println(parameterMetaData.getParameterTypeName(1));

        preparedStatement.close();
        connection.close();
    }

    @Test
    void testResultSetMetaData() throws SQLException {
        Connection connection = ConectionUtil.getDataSource().getConnection();
        String sql = """
                select email, comment from comments
                """;

        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();

        ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
        for (int i = 1; i <= resultSetMetaData.getColumnCount(); i++) {
            System.out.println("Name      : " + resultSetMetaData.getColumnName(i));
            System.out.println("Type      : " + resultSetMetaData.getColumnType(i));
            System.out.println("Type Name : " + resultSetMetaData.getColumnTypeName(i));
        }


        resultSet.close();
        preparedStatement.close();
        connection.close();

    }
}
