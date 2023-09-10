package entity;

public class Todo {

    private String todolist;

    public Todo() {
    }

    public Todo(String todolist) {
        this.todolist = todolist;
    }

    public String getTodolist() {
        return todolist;
    }

    public void setTodolist(String todolist) {
        this.todolist = todolist;
    }
}
