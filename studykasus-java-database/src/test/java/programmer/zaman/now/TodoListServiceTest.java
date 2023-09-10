package programmer.zaman.now;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import programmer.zaman.now.entity.Todo;
import programmer.zaman.now.repository.TodoRepository;
import programmer.zaman.now.repository.TodoRepositoryImpl;
import programmer.zaman.now.service.TodoListService;
import programmer.zaman.now.service.TodoListServiceImpl;
import programmer.zaman.now.utility.ConnectorUtil;

import javax.sql.DataSource;
import java.util.List;

public class TodoListServiceTest {

    DataSource dataSource = ConnectorUtil.getDataSource();
    TodoRepository todoRepository = new TodoRepositoryImpl(dataSource);
    TodoListService todoListService;

    @BeforeEach
    void setUp() {
        todoListService = new TodoListServiceImpl(todoRepository);
    }

    @Test
    void testShowTodoList() {
        todoListService.showTodoList();
    }

    @Test
    void testAddTodoList() {
        todoListService.addTodoList("berbelanja");
        List<Todo> todos = todoRepository.getAll();
        Assertions.assertNotNull(todos);
        Assertions.assertEquals(5, todos.size());
        todos.forEach(todo -> System.out.println("- " + todo.getList()));
    }

    @Test
    void testRemoveTodoList() {
        todoListService.removeTodoList(3);
        List<Todo> todos = todoRepository.getAll();
        Assertions.assertNotNull(todos);
        Assertions.assertEquals(2, todos.size());
        todos.forEach(todo -> System.out.println("- " + todo.getList()));

    }

    @Test
    void testRemoveTodoListFalse() {
        todoListService.removeTodoList(-1);
        List<Todo> todos = todoRepository.getAll();
        Assertions.assertNotNull(todos);
        Assertions.assertEquals(2, todos.size());
        todos.forEach(todo -> System.out.println("- " + todo.getList()));
    }
}
