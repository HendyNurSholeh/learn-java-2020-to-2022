import entity.Todo;
import repository.TodoRepository;
import repository.TodoRepositoryImpl;
import service.TodoService;
import service.TodoServiceImpl;
import view.TodoView;

public class AplikasiTodolistV2 {
    public static void main(String[] args) {
        TodoRepository todoRepository = new TodoRepositoryImpl();
        TodoService todoService = new TodoServiceImpl(todoRepository);
        TodoView todoView = new TodoView(todoService);
        todoView.showTodolist();
    }
}
