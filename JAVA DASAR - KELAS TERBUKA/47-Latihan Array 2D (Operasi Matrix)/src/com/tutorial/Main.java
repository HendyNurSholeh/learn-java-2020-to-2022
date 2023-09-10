package com.tutorial;
import java.util.Arrays;
public class Main {

    public static void main(String[] args) {
        // menampilkan array
        System.out.println("array 1");
         int [][]array1 ={
                 {1,2,3},
                 {4,5,6},
                 {7,8,9}
         };
         printArray(array1);
         // menambah array
        System.out.println("array 2");
        int [][]array2 ={
                {1,2},
                {3,4}
        };
        printArray(array2);
        System.out.println("array 3");
        int [][]array3 ={
                {11,12},
                {13,14}
        };
        printArray(array3);
        System.out.println("menjumlah array 2 dan array 3");
        printArray(tambah(array2,array3));
        // mengali antar array
        System.out.println("mengali array 2 dan array 3");
        printArray(kali(array2,array3));


    }
    // menampilkan array menggunakan 2 looping
    private static void printArray(int [][]array1){
        for (int i =0;i<array1.length;i++){
            System.out.print("[");
            for (int j=0;j<array1[0].length;j++){
                System.out.print(array1[i][j]);
                if (j < (array1[0].length-1)) {
                    System.out.print(",");
                }else {
                    System.out.println("]");
                }
            }
        }
        System.out.print("\n");
    }
    // menambah array menggunakan 2 looping
    private  static int [][]tambah(int [] []array2,int[][]array3) {
        int[][] hasil = new int[array2.length][array2[0].length];
        for (int i = 0; i < array2.length; i++) {
            for (int j = 0; j < array2[0].length; j++) {
                hasil[i][j] = array2[i][j] + array3[i][j];
            }
        }
     return hasil;
    }
    private static int [][]kali(int [][]array2,int[][]array3 ) {
        int [][] hasil = new int [array2.length][array3[0].length];
        int buffer;
        for (int i = 0; i < array2.length; i++) {
            for (int j = 0; j < array3[0].length; j++) {
                buffer = 0;
                for (int k = 0; k < array3.length; k++) {
                    buffer += array2[i][k] * array3[k][j];
                }
            hasil[i][j] = buffer;
            }
        }
        return hasil;
    }
}
