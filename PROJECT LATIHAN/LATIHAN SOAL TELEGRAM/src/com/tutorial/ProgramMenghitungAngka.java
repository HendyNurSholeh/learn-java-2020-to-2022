package com.tutorial;

import java.util.Scanner;

public class ProgramMenghitungAngka {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int banyakTanaman, total, potongan, hargaYangDibayar;

        System.out.println("\n----- TOKO ALADIN -----");
        System.out.println("Harga tanaman per pcs Rp. 5.000-,");
        System.out.print("Masukkan banyak tanaman yang dibeli pembeli = ");
        banyakTanaman = scanner.nextInt();

        if (banyakTanaman >= 50){
            total = banyakTanaman * 5000;
            potongan = (banyakTanaman * 5000) * 10/100;
            hargaYangDibayar = (banyakTanaman * 5000) - potongan;

            System.out.println("\nTotal                  = " + "Rp. " + total + ",-");
            System.out.println("Potongan                 = " + "Rp. " + potongan + ",-");
            System.out.println("Harga yang harus dibayar = " + "Rp. " + hargaYangDibayar + ",-");
        }else if (banyakTanaman >= 20){
            total = banyakTanaman * 5000;
            potongan = (banyakTanaman * 5000) * 5/100;
            hargaYangDibayar = (banyakTanaman * 5000) - potongan;

            System.out.println("\nTotal                  = " + "Rp. " + total + ",-");
            System.out.println("Potongan                 = " + "Rp. " + potongan + ",-");
            System.out.println("Harga yang harus dibayar = " + "Rp. " + hargaYangDibayar + ",-");
        }else{
            hargaYangDibayar = banyakTanaman * 5000;
            System.out.println("\nHarga yang harus dibayar = " + "Rp. " + hargaYangDibayar + ",-");
        }
    }
}
