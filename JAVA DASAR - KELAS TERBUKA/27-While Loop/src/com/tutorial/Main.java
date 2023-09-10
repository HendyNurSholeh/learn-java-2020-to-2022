package com.tutorial;

public class Main {

    public static void main(String[] args) {

        int a = 0;
        boolean kondisi = true;

        System.out.println("ini adalah awal dari program");
        while (kondisi){
            a++;
            System.out.println("while loop ke-"+ a);

            if (a==10){
                kondisi = false;
            }
        }
        System.out.println("akhir program");
    }
}
