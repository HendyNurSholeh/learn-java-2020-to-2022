package com.tutorial;

public class Main {

    public static void main(String[] args){

        // nested if atau if bersarang
        int a = 10;
        int b = 5;

        System.out.println("start");
        if (a == 11){
            if (b == 5){
                System.out.println("benar semua");
            }else{
                System.out.println("b salah");
            }
        }else{
            System.out.println("salah 2 duanya");
        }
        System.out.println("finish");

    }
}
