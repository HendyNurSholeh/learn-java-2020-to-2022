package programmer.zaman.now.generic.application;

import programmer.zaman.now.generic.MyData;

public class ContravariantApp {
    public static void main(String[] args) {
        MyData<Object> objectMyData = new MyData<>("usoppp");
        proccess(objectMyData);

    }
    static void proccess(MyData<? super String> myData){
        myData.setData("gomu gomuu");
        String data = (String) myData.getData();
        System.out.println(data);
    }

}
