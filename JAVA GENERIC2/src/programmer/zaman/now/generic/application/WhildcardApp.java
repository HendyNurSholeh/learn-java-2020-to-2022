package programmer.zaman.now.generic.application;

import programmer.zaman.now.generic.MyData;

public class WhildcardApp {
    public static void main(String[] args) {
        print(new MyData<>(20000));
        print(new MyData<>("usopp"));
        print(new MyData<>(new MultipleContraintApp.Manager("hahahaha")));


    }

    public static void print(MyData<?> data){
        System.out.println(data.getData());
    }
}
