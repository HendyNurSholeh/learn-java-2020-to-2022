package programmer.zaman.now.view;

import programmer.zaman.now.repository.TodoRepository;
import programmer.zaman.now.repository.TodoRepositoryImpl;
import programmer.zaman.now.service.TodoListService;
import programmer.zaman.now.service.TodoListServiceImpl;
import programmer.zaman.now.utility.ResouceBundleUtil;
import programmer.zaman.now.utility.TimeUtil;
import programmer.zaman.now.utility.UserInput;

import java.sql.SQLException;
import java.util.ResourceBundle;

public class TodoListView {
    private TodoListService todoListService;
    public static ResourceBundle view = ResouceBundleUtil.getResourceBundle();

    public TodoListView(TodoListService todoListService) {
        this.todoListService = todoListService;
    }

    public void showApp(){
        Boolean isLanjutkan = true;
        while (isLanjutkan){
            showTodoList();
            System.out.println(view.getString("menu.options"));
            String pilihan = UserInput.input(view.getString("enter.no.choice"));
            switch (pilihan){
                case "1" :
                    addTodoList();
                    break;
                case "2" :
                    removeTodoList();
                    break;
                case "x" :
                    isLanjutkan = false;
                    break;
                default :
                    System.out.println(view.getString("not.understood"));
                    break;
            }
        }
    }

    public void showTodoList(){
        System.out.println("\nTODOLIST : ");
        todoListService.showTodoList();
    }

    public void addTodoList(){
        System.out.println(view.getString("add"));
        String todoList = UserInput.input(view.getString("input.todolist"));
        if (!todoList.equals("x")){
            todoListService.addTodoList(todoList);
            System.out.print(view.getString("success.add.todo") + "\"" + todoList + "\" ");
            System.out.println(TimeUtil.getTime());
        }
    }

    public void removeTodoList() throws NumberFormatException{
        System.out.println(view.getString("remove"));
        String noTodo = UserInput.input(view.getString("input.no.todolist"));
        if (!noTodo.equals("x")){
            boolean inputSalah = true;
            while (inputSalah){
                try {
                    Integer nomorTodoList = Integer.valueOf(noTodo);
                    todoListService.removeTodoList(nomorTodoList);
                    inputSalah = false;
                }catch (NumberFormatException exception){
                    System.out.println(view.getString("not.understood"));
                    noTodo = UserInput.input(view.getString("input.no.todolist"));
                    if (noTodo.equals("x")){
                        break;
                    }
                    continue;
                }
            }
        }
    }

}
