package com.tutorial;

public class Main {

    public static void main(String[] args) {
        int hasilInt;
        hasilInt = jumlah(5,4);
        printAngka(hasilInt);

        float hasilFloat;
        hasilFloat = jumlah(4.5f,4);
        printAngka(hasilFloat);

        double hasilDouble;
        hasilDouble = jumlah(4.5d,4);
        printAngka(hasilDouble);

        hasilDouble = jumlah(10.7f,12.1d,10);
        printAngka(hasilDouble);


        printAngka(10);
        printAngka(10.5f);
        printAngka(16.7d);
        printAngka(16);

    }
    private static double jumlah (float float1,double double1,int integer1) {
        return float1 + double1+ integer1;
    }
    private static int jumlah (int integer1,int integer2){
        return integer1+integer2;
    }
    private static float jumlah (float float1,int integer2){
        return float1+integer2;
    }
    private static double jumlah (double double1,int integer2) {
        return double1 + integer2;
    }
    private static void printAngka(int tampilan){
        System.out.println("angka ini adalah integer dengan nilai = "+tampilan);
    }
    private static void printAngka(float tampilan) {
        System.out.println("angka ini adalah float dengan nilai = " + tampilan);
    }
    private static void printAngka(double tampilan) {
        System.out.println("angka ini adalah double dengan nilai = " + tampilan);
    }
}
