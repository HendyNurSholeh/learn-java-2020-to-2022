package programmer.zaman.now;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import programmer.zaman.now.entity.Todo;
import programmer.zaman.now.repository.TodoRepository;
import programmer.zaman.now.repository.TodoRepositoryImpl;
import programmer.zaman.now.utility.ConnectorUtil;

import javax.sql.DataSource;
import java.util.List;

public class TodoRepositoryTest {

    DataSource dataSource = ConnectorUtil.getDataSource();
    TodoRepository todoRepository;

    @BeforeEach
    void setUp() {
        todoRepository = new TodoRepositoryImpl(dataSource);
    }

    @Test
    void testGetAll() {
        List<Todo> todos = todoRepository.getAll();
        Assertions.assertNotNull(todos);
        Assertions.assertEquals(3, todos.size());
        todos.forEach(todo -> System.out.println("- " + todo.getList()));
    }

    @Test
    void testInsertTodo() {
        todoRepository.insertTodo("nyantaii");
        List<Todo> todos = todoRepository.getAll();
        Assertions.assertNotNull(todos);
        Assertions.assertEquals(4, todos.size());
        todos.forEach(todo -> System.out.println("- " + todo.getList()));
    }

    @Test
    void testRemoveTodo() {
        todoRepository.removeByList("BERBELANJA");
        List<Todo> todos = todoRepository.getAll();
        Assertions.assertNotNull(todos);
        Assertions.assertEquals(4, todos.size());
        todos.forEach(todo -> System.out.println("- " + todo.getList()));
    }
}
