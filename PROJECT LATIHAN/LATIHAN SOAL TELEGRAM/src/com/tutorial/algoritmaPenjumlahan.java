package com.tutorial;

public class algoritmaPenjumlahan {
    public static void main(String[] args) {

        int arrayAngka[] = {2,12,3,14,29,4};
        int total = 0;

        for (int i = 0; i < arrayAngka.length ; i++) {
            System.out.println("Pertambahan " + arrayAngka[i]);
            System.out.println("--------------");
            for (int j = (i + 1) ; j < arrayAngka.length; j++) {
                System.out.print(arrayAngka[i] + " + " + arrayAngka[j] + " = ");
                System.out.println(arrayAngka[i] + arrayAngka[j]);
                total += arrayAngka[i] + arrayAngka[j];
            }
            System.out.println("Total = " + total);
            total = 0;
            System.out.println();
        }
    }
}
