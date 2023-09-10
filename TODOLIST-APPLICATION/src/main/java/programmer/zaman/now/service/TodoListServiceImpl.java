package programmer.zaman.now.service;

import programmer.zaman.now.entity.Todo;
import programmer.zaman.now.repository.TodoRepository;
import programmer.zaman.now.utility.ResouceBundleUtil;
import programmer.zaman.now.utility.TimeUtil;
import programmer.zaman.now.view.TodoListView;

import java.util.List;
import java.util.ResourceBundle;
import java.util.concurrent.atomic.AtomicInteger;

public class TodoListServiceImpl implements TodoListService{

    TodoRepository todoRepository;

    private ResourceBundle view = ResouceBundleUtil.getResourceBundle();

    public TodoListServiceImpl(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    @Override
    public void showTodoList() {
        List<Todo> allTodo = todoRepository.getAll();
        if (allTodo.isEmpty()){
            System.out.println(view.getString("todo.empty"));
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
    }

    @Override
    public void removeTodoList(Integer noTodo) {
        if (! (noTodo > todoRepository.getAll().size() || noTodo <= 0)){
            Todo todo = todoRepository.getAll().get(noTodo - 1);
            todoRepository.removeByList(todo.getList());
            System.out.print(view.getString("success.remove.todo")+ todo.getList());
            System.out.println(TimeUtil.getTime());
        } else {
            System.out.println(view.getString("number.not.exist"));
        }
    }
}
