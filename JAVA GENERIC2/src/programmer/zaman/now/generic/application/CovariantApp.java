package programmer.zaman.now.generic.application;

import programmer.zaman.now.generic.MyData;

public class CovariantApp {
    public static void main(String[] args) {
        // GENERIC BERSIFAT COVARIANT, ARTINYA PADA SAAT MENGGUNAKAN POLIMORPISHM MAKA DATA HANYA READ ONLY
        MyData<String> stringMyData = new MyData<>("Otong Surotong");;
        MyData<? extends Object> objectMyData = stringMyData;

        process(stringMyData);
        System.out.println(objectMyData.getData());


    }

    static <T> int process(MyData<? extends Object> myData){
        System.out.println(myData.getData());
//        myData.setData("usoppp"); // ERROR
        return 1;
    }
}
