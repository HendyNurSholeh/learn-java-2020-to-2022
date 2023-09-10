package com.tutorial;

import programmer.zaman.now.AplikasiTodoList;

public class Flowchart {
    public static void main(String[] args) {
        int Bil = 10;
        while (Bil <= 30){
            if (Bil%2==1){
                if ((Bil==21) || (Bil==27)){
                    Bil++;
                }else {
                    System.out.println(Bil);
                    Bil++;
                }
            }else {
                Bil++;
            }
        }
        System.out.println("End");
    }
}
