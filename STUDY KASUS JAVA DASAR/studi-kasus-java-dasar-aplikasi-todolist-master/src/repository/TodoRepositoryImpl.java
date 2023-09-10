package repository;

import entity.Todo;

public class TodoRepositoryImpl implements TodoRepository {

    private Todo[] data = new Todo[10];

    @Override
    public Todo[] getAll() {
        return data;
    }

    public boolean isFull(){
        // cek apakah model penuh?
        var isFull = true;
        for (int i = 0; i < data.length; i++) {
            if (data[i] == null) {
                // model masih ada yang kosong
                isFull = false;
                break;
            }
        }
        return isFull;
    }

    public void risizeIsFull(){
        // jika penuh, kita resize ukuran array 2x lipat
        if (isFull()) {
            var temp = data;
            data = new Todo[data.length * 2];

            for (int i = 0; i < temp.length; i++) {
                data[i] = temp[i];
            }
        }

    }

    @Override
    public void addTodolist(Todo todo) {
        // cek apakah penuh?
        risizeIsFull();

        // tambahkan ke posisi yang data array nya NULL
        for (var i = 0; i < data.length; i++) {
            if (data[i] == null) {
                data[i] = todo;
                break;
            }
        }
    }

    @Override
    public boolean removeTodoList(Integer number) {
        if ((number - 1) >= data.length) {
            return false;
        } else if (data[number - 1] == null) {
            return false;
        } else {
            for (int i = (number - 1); i < data.length; i++) {
                if (i == (data.length - 1)) {
                    data[i] = null;
                } else {
                    data[i] = data[i + 1];
                }
            }
            return true;
        }
    }
}
