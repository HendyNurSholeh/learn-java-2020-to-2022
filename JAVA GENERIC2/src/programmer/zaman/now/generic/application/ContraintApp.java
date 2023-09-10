package programmer.zaman.now.generic.application;

public class ContraintApp {
    public static void main(String[] args) {
//        NumberData<String> stringNumberData = new NumberData<>(); // ERROR
        NumberData<Integer> integerNumberData = new NumberData<>(2000);
        System.out.println(integerNumberData.getData());

    }

    static class NumberData<T extends Number>{
        T data;

        public NumberData(T data) {
            this.data = data;
        }

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }
    }
}
