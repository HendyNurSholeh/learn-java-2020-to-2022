package test.view;

import repository.TodoRepository;
import repository.TodoRepositoryImpl;
import service.TodoService;
import service.TodoServiceImpl;
import view.TodoView;

public class TodoViewTest {
    public static void main(String[] args) {
    }

    static void testShowTodolist(){
        TodoRepository todoRepository = new TodoRepositoryImpl();
        TodoService todoService = new TodoServiceImpl(todoRepository);
        TodoView todoView = new TodoView(todoService);
        todoService.addTodoList("makan");
        todoService.addTodoList("minum");
        todoService.addTodoList("mandi");
        todoView.showTodolist();

    }
     static void testAddTodolist(){
         TodoRepository todoRepository = new TodoRepositoryImpl();
         TodoService todoService = new TodoServiceImpl(todoRepository);
         TodoView todoView = new TodoView(todoService);

         todoView.addTodolist();
         todoService.showTodolist();
     }
     static void testRemoveTodolist(){
         TodoRepository todoRepository = new TodoRepositoryImpl();
         TodoService todoService = new TodoServiceImpl(todoRepository);
         TodoView todoView = new TodoView(todoService);
         todoService.addTodoList("makan");
         todoService.addTodoList("minum");
         todoService.addTodoList("mandi");
         todoService.showTodolist();
         todoView.removeTodoList();
         todoService.showTodolist();
     }


}
