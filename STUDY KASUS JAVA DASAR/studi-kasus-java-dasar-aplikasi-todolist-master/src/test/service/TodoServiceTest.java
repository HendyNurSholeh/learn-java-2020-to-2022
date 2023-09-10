package test.service;
import entity.Todo;
import repository.TodoRepository;
import repository.TodoRepositoryImpl;
import service.TodoService;
import service.TodoServiceImpl;

public class TodoServiceTest {
    public static void main(String[] args) {
        testRemoveTodolist();
    }

    static void testShowTodolist(){
        TodoRepositoryImpl todoRepository = new TodoRepositoryImpl();
        TodoService todoService = new TodoServiceImpl(todoRepository);
        todoService.showTodolist();
    }

    static void testAddTodolist(){
        TodoRepository todoRepository = new TodoRepositoryImpl();
        TodoService todoService = new TodoServiceImpl(todoRepository);
        todoService.addTodoList("makan");
        todoService.addTodoList("makan");
        todoService.showTodolist();
    }

    static void testRemoveTodolist(){
        TodoRepository todoRepository = new TodoRepositoryImpl();
        TodoService todoService = new TodoServiceImpl(todoRepository);
        todoService.addTodoList("makan1");
        todoService.addTodoList("makan2");
        todoService.addTodoList("makan3");
        todoService.addTodoList("makan4");
        todoService.showTodolist();
        todoService.removeTodoList(2);
        todoService.showTodolist();
    }

}
