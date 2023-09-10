package programmer.zaman.now.entity;

public class Todo {

    private Integer id;

    private String list;

    public Todo() {
    }

    public Todo(String list) {
        this.list = list;
    }

    public Todo(Integer id, String list) {
        this.id = id;
        this.list = list;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getList() {
        return list;
    }

    public void setList(String list) {
        this.list = list;
    }
}
