package com.tutorial;

public class Main {

    public static void main(String[] args) {

        // Operasi Aritmatika

        int variable1 = 9;
        int variable2 = 7;

        int hasil;

        // 1.Penjumlahan
        hasil = variable1 + variable2;
        System.out.println(variable1 +" + "+ variable2 +" = "+hasil);

        // 2.Pengurangan
        hasil = variable1 - variable2;
        System.out.printf("%d - %d = %d\n",variable1,variable2,hasil);

        // 3.Perkalian
        hasil = variable1 * variable2;
        System.out.printf("%d x %d = %d\n",variable1,variable2,hasil);

        // 4.Pembagian
        hasil = variable1 / variable2;
        System.out.printf("%d / %d = %d\n",variable1,variable2,hasil);

        float a = 5;
        float b = 7;
        float hasilFloat = a/b;
        System.out.println(a + " / " + b + " = " + hasilFloat);

        // 5.Modulus
        hasil = variable1 % variable2;
        System.out.printf("%d %% %d = %d\n",variable1,variable2,hasil);

    }
}
