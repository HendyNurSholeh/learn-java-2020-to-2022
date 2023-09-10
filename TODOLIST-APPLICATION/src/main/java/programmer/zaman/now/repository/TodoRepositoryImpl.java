package programmer.zaman.now.repository;

import programmer.zaman.now.entity.Todo;
import programmer.zaman.now.utility.ConnectorUtil;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TodoRepositoryImpl implements TodoRepository{

    DataSource dataSource;

    public TodoRepositoryImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public List<Todo> getAll() {
        String sql = "select * from todo";
        try(Connection connection = dataSource.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql)){
            List<Todo> allTodo = new ArrayList<>();
            while (resultSet.next()){
                allTodo.add(new Todo(
                        resultSet.getInt("id"),
                        resultSet.getString("list")
                ));
            }
            return allTodo;
        }catch (SQLException exception){
            throw new RuntimeException(exception);
        }
    }

    @Override
    public void insertTodo(String todo) {
        String sql = """
                insert into todo(list)
                values(?)
                """;
        try(Connection connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setString(1, todo);
            statement.executeUpdate();
        }catch (SQLException exception){
            throw new RuntimeException(exception);
        }
    }

    @Override
    public void removeByList(String list) {
        String sql = """
                delete from todo
                where list = ?
                """;
        try(Connection connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setString(1, list);
            statement.executeUpdate();
        }catch (SQLException exception){
            throw new RuntimeException(exception);
        }
    }
}
