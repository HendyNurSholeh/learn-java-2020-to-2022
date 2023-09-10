package view;

import Util.Input.Utility;
import service.TodoService;

public class TodoView {
    private TodoService todoService;

    public TodoView(TodoService todoService) {
        this.todoService = todoService;
    }

    public void showTodolist() {
        while (true) {
            todoService.showTodolist();
            System.out.println("MENU : ");
            System.out.println("1. Tambah");
            System.out.println("2. Hapus");
            System.out.println("x. Keluar");

            var input = Utility.input("Pilih");

            if (input.equals("1")) {
                addTodolist();
            } else if (input.equals("2")) {
                removeTodoList();
            } else if (input.equals("x")) {
                break;
            } else {
                System.out.println("Pilihan tidak dimengerti");
            }
        }
    }

    public void addTodolist(){
        System.out.println("MENAMBAH TODOLIST");
        String input = Utility.input("Masukkan todolist (x jika batal)");
        if (input.equals("x")){
            // batal
        }else {
            todoService.addTodoList(input);
        }
    }

    public void removeTodoList(){
        String input = Utility.input("Masukkan nomor todolist (x jika batal)");
        if (input.equals("x")){
            // batal
        }else {
            todoService.removeTodoList(Integer.valueOf(input));
        }
    }
}
