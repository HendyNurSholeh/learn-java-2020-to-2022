package repository;

import entity.Todo;

public interface TodoRepository {

    Todo[] getAll();

    void addTodolist(Todo todo);

    boolean removeTodoList(Integer todo);

}
