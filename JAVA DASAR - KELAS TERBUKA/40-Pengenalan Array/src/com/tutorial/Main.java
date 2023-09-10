package com.tutorial;
import java.util.Arrays;
public class Main {

    public static void main(String[] args) {
        // asignment array
        // tipedata [] nama = {komponen-komponen}
        System.out.println("asigment Array");
        int [] arrayinteger={11,2,3,4};
        System.out.println(arrayinteger[0]);
        System.out.println(arrayinteger[1]);
        System.out.println(arrayinteger[2]);
        System.out.println(arrayinteger[3]);

        // deklarasi
        // tipedata [] nama = new tipedata [jumlah array]

        System.out.println("Deklarasi Array");
        float [] arrayFloat = new float[5];
        arrayFloat[3]=11.5f;
        System.out.println(arrayFloat[0]);
        System.out.println(arrayFloat[1]);
        System.out.println(arrayFloat[2]);
        System.out.println(arrayFloat[3]);
        System.out.println(arrayFloat[4]);

        System.out.println( Arrays.toString(arrayinteger));
        System.out.println( Arrays.toString(arrayFloat));
    }
}
