package programmer.zaman.now.generic.application;

import programmer.zaman.now.generic.MyData;

public class ContravariantApp {
    public static void main(String[] args) {

        MyData<Object> objectMyData = new MyData<>("Eko");
        MyData<? super String> myData = objectMyData;

        processor(objectMyData);
    }

    public static void processor(MyData<? super String> myData){
        Object value = myData.getData();
        System.out.println("Processor parameter "+ value);

        myData.setData("Eko kurniawan");
    }

}
