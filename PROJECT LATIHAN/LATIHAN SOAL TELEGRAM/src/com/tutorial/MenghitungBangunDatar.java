package com.tutorial;

import jdk.swing.interop.SwingInterOpUtils;

import java.util.Scanner;

public class MenghitungBangunDatar {
    public static void main(String[] args) {
        showList();
    }
    static void showList(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("=======PROGRAM MENGHITUNG BANGUN DATAR=======");
        System.out.println("1. Type : Lingkaran 3 lapis");
        System.out.println("2. Type : Persegi 2 lapis");
        System.out.println("3. Type : Persegi panjang 2 lapis");
        System.out.println("4. Type : Segitiga 2 lapis");
        System.out.println("5. Type : Persegi panjang 3 lapis + lingkaran ");
        System.out.print("Masukkan nomor type bangunan yang anda pilih (1/2/3) = ");
        String pilihan = scanner.nextLine();
        switch (pilihan){
            case "1" :
                viewLingkaran();
                break;
            case "2" :
                viewPersegi();
                break;
            case "3" :
                viewPersegiP();
                break;
            case "4" :
                viewSegitiga();
                break;
            case "5" :
                viewKombinasi();
                break;
            default:
                System.out.println("pilihan anda tidak ada!!");
        }
    }
    // TYPE 1 (LINGKARAN)
    static void viewLingkaran(){
        System.out.println("\n-----MENGHITUNG LUAS LUNGKARAN 3 LAPIS-----");
        System.out.print("Masukkan diameter lingkaran1 (cm) : ");
        double luas1 = luasLingkaran();
        System.out.print("Masukkan diameter lingkaran2 (cm) : ");
        double luas2 = luasLingkaran();
        System.out.print("Masukkan diameter lingkaran3 (cm) : ");
        double luas3 = luasLingkaran();
        System.out.print("Luas lingkaran adalah : ");
        System.out.println(hasilAkhir(luas1, luas2, luas3) + " cm");
    };
    static double hasilAkhir(double luas1, double luas2, double luas3){
        double hasil = luas1 - luas2 + luas3;
        return hasil;
    };
    static double luasLingkaran(){
        Scanner scanner = new Scanner(System.in);
        double diameter = scanner.nextFloat();
        double R = diameter/2;
        double hasil = 3.14 * (R*R);
        return  hasil;
    }

    // TYPE 2,3,4
    static double hasil(double luas1, double luas2){
        double hasil = luas1 - luas2;
        return hasil;
    }

    // TYPE 2 (PERSEGI)
    static void viewPersegi(){
        System.out.println("-----MENGHITUNG PERSEGI 2 LAPIS-----");
        System.out.print("Masukkan panjang sisi persegi1 (cm) = ");
        double luas1 = luasPersegi();
        System.out.print("Masukkan panjang sisi persegi2 (cm) = ");
        double luas2 = luasPersegi();
        System.out.print("Luas persegi adalah : ");
        System.out.println(hasil(luas1, luas2) + " cm");
    }
    static double luasPersegi(){
        Scanner scanner = new Scanner(System.in);
        double panjangSisi = scanner.nextDouble();
        double hasil = panjangSisi * panjangSisi;
        return hasil;
    }

    // TYPE 3 (PERSEGI PANJANG)
    static void viewPersegiP(){
        System.out.println("-----MENGHITUNG PERSEGI PANJANG 2 LAPIS-----");
        double luas1 = luasPersegiP("persegi1");
        double luas2 = luasPersegiP("persegi2");
        System.out.print("Luas persegi panjang adalah : ");
        System.out.println(hasil(luas1, luas2) + " cm");
    }
    static double luasPersegiP(String persegi){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Masukkan panjang " + persegi + "  = ");
        double panjang = scanner.nextDouble();
        System.out.print("Masukkan lebar " + persegi + "    = ");
        double lebar = scanner.nextDouble();
        double hasil = lebar * panjang;
        return hasil;
    }

    // TYPE 4
    static void viewSegitiga(){
        System.out.println("-----Menghitung luas segitiga 2 lapis-----");
        double luas1 = luasSegitiga("segitiga1");
        double luas2 = luasSegitiga("segitiga2");
        System.out.print("Luas segitiga adalah : ");
        System.out.println(hasil(luas1, luas2) + " cm");
    }
    static double luasSegitiga(String segitiga){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Masukkan panjang alas " + segitiga + " (cm) = ");
        double alas = scanner.nextDouble();
        System.out.print("Masukkan tinggi " + segitiga + " (cm)       = ");
        double tinggi = scanner.nextDouble();
        double hasil = (0.5 * alas) * tinggi;
        return hasil;
    }

    // TYPE 5
    static void viewKombinasi(){
        System.out.println("-----MENGHITUNG LUAS PERSEGI PANJANG 3 LAPIS + LINGKARAN----");
        double luas1 = luasPersegiP("persegi panjang");
        System.out.print("Masukkan panjang sisi persegi1    = ");
        double luas2 = luasPersegi();
        System.out.print("Masukkan panjang sisi persegi2    = ");
        double luas3 = luasPersegi();
        System.out.print("Masukkan diameter lingkaran       = ");
        double luas4 = luasLingkaran();
        double hasil = hasilKombinasi(luas1, luas2, luas3, luas4);
        System.out.println("Luas persigi panjang adalah : " + hasil + " cm");
    }
    static double hasilKombinasi(double luas1, double luas2, double luas3, double luas4){
        double hasil = luas1 - luas2 - luas3 - luas4;
        return hasil;
    }

}