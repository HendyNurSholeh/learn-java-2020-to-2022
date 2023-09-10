package com.tutorial;
import java.util.Arrays;
public class Main {
    public static void main(String[] args) {
        System.out.println("belajar array multidimensi");

        // cara membuat array 2 dimensi dengan assignment
        int [][] array_2D = {
                {3,4},
                {5,6}
        };
        printArray2D(array_2D);

        // cara membuat array 2 dimensi dengan assignment
        // int [baris] [kolom]
        System.out.println("memakai for");
        int [][] arrayangka = new int[5][4];
        printArray2D(arrayangka);

        // looping lengkap secara manual
        System.out.println("memakai for secara manual");
        for (int i = 0;i<arrayangka.length;i++){
            System.out.print("[");
            for (int j=0;j<arrayangka[i].length;j++){
                System.out.print(arrayangka[i][j]+",");
            }
            System.out.print("]\n");
        }

        // looping foreach
        System.out.println("memakai foreach");
        for (int [] baris : arrayangka){
            System.out.print("[");
            for(int angka : baris){
                System.out.print(angka+",");
            }
            System.out.print("]\n");
        }


    }
    private static void printArray2D(int [][] array_2D){
        for (int i = 0;i<array_2D.length;i++){
            System.out.println(Arrays.toString(array_2D[i]));
        }

    }
}
