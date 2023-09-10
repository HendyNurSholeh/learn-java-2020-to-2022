package programmer.zaman.now.application;

import programmer.zaman.now.eror.DataBase;

public class DataBaseApp {
    public static void main(String[] args) {
        connectDataBase("eko", "eko");
        System.out.println("Sukses");
    }
    public static void connectDataBase(String username, String password){
        if (username == null||password == null){
            throw new DataBase("tidak bisa connect ke database");
        }
    }
}
