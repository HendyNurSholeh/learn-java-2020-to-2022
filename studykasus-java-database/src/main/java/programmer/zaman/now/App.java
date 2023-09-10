package programmer.zaman.now;

import com.zaxxer.hikari.HikariDataSource;
import programmer.zaman.now.entity.Todo;
import programmer.zaman.now.repository.TodoRepository;
import programmer.zaman.now.repository.TodoRepositoryImpl;
import programmer.zaman.now.service.TodoListService;
import programmer.zaman.now.service.TodoListServiceImpl;
import programmer.zaman.now.utility.ConnectorUtil;
import programmer.zaman.now.view.TodoListView;

import javax.sql.DataSource;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args ) {
        DataSource dataSource = ConnectorUtil.getDataSource();
        TodoRepository todoRepository = new TodoRepositoryImpl(dataSource);
        TodoListService todoListService = new TodoListServiceImpl(todoRepository);
        TodoListView todoListView = new TodoListView(todoListService);

        todoListView.showApp();
    }
}
