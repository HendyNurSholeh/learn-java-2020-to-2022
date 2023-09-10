package service;

import entity.Todo;
import repository.TodoRepository;

public class TodoServiceImpl implements TodoService{

    private TodoRepository repository;

    public TodoServiceImpl(TodoRepository repository) {
        this.repository = repository;
    }

    @Override
    public void showTodolist() {
        var data = repository.getAll();
        System.out.println("\nTODOLIST");
        for (var i = 0; i < data.length; i++) {
            var todo = data[i];
            var no = i + 1;
            if (todo != null) {
                System.out.println(no + ". " + todo.getTodolist());
            }
        }
    }

    @Override
    public void addTodoList(String todo) {
        Todo todolist = new Todo(todo);
        repository.addTodolist(todolist);
        System.out.println("SUKSES MENAMBAH TODO : " + todo);
    }

    @Override
    public void removeTodoList(Integer todo) {
        var success = repository.removeTodoList(todo);
        if (success){
            System.out.println("BERHASIL MENGHAPUS TODO : " + todo);
        }else {
            System.out.println("GAGAL MENGHAPUS TODO : " + todo);
        }
    }
}
