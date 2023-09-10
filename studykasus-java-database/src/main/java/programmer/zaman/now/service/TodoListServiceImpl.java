package programmer.zaman.now.service;

import programmer.zaman.now.entity.Todo;
import programmer.zaman.now.repository.TodoRepository;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class TodoListServiceImpl implements TodoListService{

    TodoRepository todoRepository;

    public TodoListServiceImpl(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    @Override
    public void showTodoList() {
        List<Todo> allTodo = todoRepository.getAll();
        if (allTodo.isEmpty()){
            System.out.println("//Todolist masih kosong,");
            System.out.println("//Silahkan tambahkan Todolist terlebih dahulu");
        }else {
            AtomicInteger nomor = new AtomicInteger();
            for (int i = 0; i < allTodo.size(); i++) {
                System.out.println(nomor.addAndGet(1) + ". " + allTodo.get(i).getList());
            }
        }

    }

    @Override
    public void addTodoList(String todo) {
        todoRepository.insertTodo(todo);
        System.out.println("//Sukses Menambah Todo : " + todo);
    }

    @Override
    public void removeTodoList(Integer noTodo) {
        if (! (noTodo > todoRepository.getAll().size() || noTodo <= 0)){
            Todo todo = todoRepository.getAll().get(noTodo - 1);
            todoRepository.removeByList(todo.getList());
            System.out.println("//Sukses Menghapus Todo : " + todo.getList());
        } else {
            System.out.println("//Nomor list yang anda masukkan tidak ada");
        }
    }
}
