package com.tutorial;
import java.util.Arrays;
public class Main {

    public static void main(String[] args) {
        // alasan mengapa array 2D di java bisa berbeda jumlah komponen antara array 1 dan lainnya
        // karna array yang ada di java diletakkan di addres yg berbeda
        int [] array1={1,2,3};
        int [] array2={4,5};
        int[][] array_2D = {
                array1,
                array2
        };
        // addres array_2D
        System.out.println(array_2D);
        // addres array1
        System.out.println(array1);
        // addres array2
        System.out.println(array2);

        System.out.print("\n");
        System.out.println(array_2D[0]);//addres sama dengan array1
        System.out.println(array_2D[1]);//addres sama dengan array2
    }
}
