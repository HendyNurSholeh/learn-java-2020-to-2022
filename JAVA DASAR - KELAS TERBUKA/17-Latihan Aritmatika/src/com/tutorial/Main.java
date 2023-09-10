package com.tutorial;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner userInput = new Scanner(System.in);
        int panjang,lebar,luas,tinggi,volume;

        // Membuat Perhitungan Menghitung Luas Persegi Panjang
        // luas = Panjang x Lebar

        System.out.println("MENGHITUNG LUAS");
        System.out.print("Panjang = ");
        panjang = userInput.nextInt();
        System.out.print("Lebar = ");
        lebar = userInput.nextInt();
        luas = panjang*lebar;
        System.out.println("luas = "+ luas);

        System.out.println("MENGHITUNG VOLUME");
        System.out.println("Tinggi = ");
        tinggi = userInput.nextInt();
        volume = luas * tinggi;
        System.out.println("Volume = "+ volume);

    }
}
