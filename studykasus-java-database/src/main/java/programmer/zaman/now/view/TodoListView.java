package programmer.zaman.now.view;

import programmer.zaman.now.repository.TodoRepository;
import programmer.zaman.now.repository.TodoRepositoryImpl;
import programmer.zaman.now.service.TodoListService;
import programmer.zaman.now.service.TodoListServiceImpl;
import programmer.zaman.now.utility.UserInput;

import java.sql.SQLException;

public class TodoListView {
    TodoListService todoListService;

    public TodoListView(TodoListService todoListService) {
        this.todoListService = todoListService;
    }

    public void showApp(){
        Boolean isLanjutkan = true;
        while (isLanjutkan){
            showTodoList();
            System.out.println("Pilihan Menu : ");
            System.out.println("1. Menambah TodoList");
            System.out.println("2. Menghapus TodoList");
            System.out.println("x. Keluar");
            String pilihan = UserInput.input("Masukkan no pilihan");
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
                    System.out.println("//Pilihan tidak dimengarti");
                    break;
            }
        }
    }

    public void showTodoList(){
        System.out.println("\nTODOLIST : ");
        todoListService.showTodoList();
    }

    public void addTodoList(){
        System.out.println("\nMENAMBAH TODOLIST : ");
        String todoList = UserInput.input("Masukkan TodoList (x jika batal)");
        if (!todoList.equals("x")){
            todoListService.addTodoList(todoList);
        }
    }

    public void removeTodoList() throws NumberFormatException{
        System.out.println("\nMENGHAPUS TODOLIST : ");
        String noTodo = UserInput.input("Masukkan nomor TodoList (x jika batal)");
        if (!noTodo.equals("x")){
            boolean inputSalah = true;
            while (inputSalah){
                try {
                    Integer nomorTodoList = Integer.valueOf(noTodo);
                    todoListService.removeTodoList(nomorTodoList);
                    inputSalah = false;
                }catch (NumberFormatException exception){
                    System.out.println("//Input tidak dimengerti silahkan masukkan dengan benar");
                    noTodo = UserInput.input("Masukkan nomor TodoList (x jika batal)");
                    continue;
                }
            }
        }
    }

}
