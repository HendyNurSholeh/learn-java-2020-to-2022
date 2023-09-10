package programmer.zaman.now.generic.application;

import programmer.zaman.now.generic.MyData;

import javax.management.ObjectName;

public class InvariantApp {
    public static void main(String[] args) {
        // POLIMORPISHM TIDAK BERLAKU DI GENERIC
        MyData<String> stringMyData = new MyData<>("Khannedy");
//        doIt(stringMyData); // ini ERROR
//        MyData<Object> objectMyData = stringMyData; // ini ERROR

    }

    public static void doIt (MyData<Object> data){

    }

}
