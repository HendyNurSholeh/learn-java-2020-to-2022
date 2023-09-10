package com.tutorial;

public class Main {

    public static void main(String[] args){

        // Operator komparasi.. ini akan menghasilkan nilai dalam bentuk boolean

        int a,b;
        boolean hasilKomparasi;

        // Operator equal atau persamaan
        System.out.println("------PERSAMAAN------");
        a = 15;
        b = 15;
        hasilKomparasi = a==b;
        System.out.printf("%d == %d --> %s\n",a,b,hasilKomparasi);

        a = 14;
        b = 15;
        hasilKomparasi = a==b;
        System.out.printf("%d == %d --> %s\n",a,b,hasilKomparasi);

        // Operator not equal atau pertidaksamaan
        System.out.println("------PERTIDAKSAMAAN------");
        a = 15;
        b = 15;
        hasilKomparasi = a!=b;
        System.out.printf("%d != %d --> %s\n",a,b,hasilKomparasi);

        a = 14;
        b = 15;
        hasilKomparasi = a!=b;
        System.out.printf("%d != %d --> %s\n",a,b,hasilKomparasi);

        // Operator less than atau kurang dari
        System.out.println("-----KURANG DARI-----");
        a = 15;
        b = 15;
        hasilKomparasi = a<b;
        System.out.printf("%d < %d --> %s\n",a,b,hasilKomparasi);

        a = 14;
        b = 15;
        hasilKomparasi = a<b;
        System.out.printf("%d < %d --> %s\n",a,b,hasilKomparasi);

        // Operator greater than equal atau lebih dari sama dengan
        System.out.println("-----LEBIH DARI SAMA DENGAN-----");
        a = 15;
        b = 15;
        hasilKomparasi = a>=b;
        System.out.printf("%d >= %d --> %s\n",a,b,hasilKomparasi);

        a = 14;
        b = 15;
        hasilKomparasi = a>=b;
        System.out.printf("%d >= %d --> %s\n",a,b,hasilKomparasi);
    }
}
