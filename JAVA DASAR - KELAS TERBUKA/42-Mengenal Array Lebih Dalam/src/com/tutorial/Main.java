package com.tutorial;
import java.util.Arrays;
public class Main {
    public static void main (String[] args){

        int [] array1 = {1,2,3,4,5};
        int [] array2 = new int[5];

        System.out.println(array1);
        System.out.println(array2);
        array2 = array1;// kunci utama
        // jika array disamadengankan maka akan menjadi 1 addres/1memori
        System.out.println(array1);
        System.out.println(array2);

        System.out.println("array 1 -> "+Arrays.toString(array1));
        System.out.println("array 1 -> "+Arrays.toString(array2));

        array1 [0]=100;
        array2 [4]=400;
        System.out.println("array 1 -> "+Arrays.toString(array1));
        System.out.println("array 1 -> "+Arrays.toString(array2));

        ubahArray(array1);
        System.out.println("array 1 -> "+Arrays.toString(array1));
        System.out.println("array 1 -> "+Arrays.toString(array2));

    }
    // method yang argumentnya adalah referensi
    // bukan nilainya
    private static void ubahArray(int [] dataArray){
        dataArray[0]=125;
    }
}
