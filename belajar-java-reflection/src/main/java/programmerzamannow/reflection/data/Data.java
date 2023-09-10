package programmerzamannow.reflection.data;

public class Data<T extends AutoCloseable>{

    private T data;

    public Data(T data) {
        this.data = data;
    }

    public Data() {
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
