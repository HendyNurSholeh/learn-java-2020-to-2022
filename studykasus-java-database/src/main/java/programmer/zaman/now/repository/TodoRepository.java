package programmer.zaman.now.repository;

import programmer.zaman.now.entity.Todo;

import java.util.List;

public interface TodoRepository {

    List<Todo> getAll();

    void insertTodo(String todo);

    void removeByList(String todo);

}
