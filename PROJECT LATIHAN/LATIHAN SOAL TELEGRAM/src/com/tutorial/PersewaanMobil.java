package com.tutorial;
import java.util.Scanner;

public class PersewaanMobil {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String jenisMobil, inputSopir;
        int lamaHariMobil, biayaMobil, totalBiaya;
        int biayaSopir = 0;

        System.out.println("\n----- PERSEWAAN MOBIL -----");
        System.out.println("BIAYA SEWA MOBIL PER HARI");
        System.out.println("Jenis Mobil :");
        System.out.println("  a.  Avanza         = Rp. 175.000,-");
        System.out.println("  b.  Kijang Innova  = Rp. 250.000,-");
        System.out.println("  c.  Luxio          = Rp. 225.000,-");
        System.out.println("Biaya sopir per hari = Rp. 150.000,-");

        System.out.print("\nMasukkan pilihan jenis mobil (a/b/c) ? ");
        jenisMobil = scanner.next();
        System.out.print("Apakah anda ingin menggunakan sopir (y/t) ? ");
        inputSopir = scanner.next();
        if (inputSopir.equalsIgnoreCase("y")){
            biayaSopir = 150000;
        }else if (inputSopir.equalsIgnoreCase("t")){
            biayaSopir = 0;
        }else {
            System.out.println("input tidak ditemukan");
        }

        System.out.print("Masukkan jumlah hari penyewaan (1/2/3/..) ? ");
        lamaHariMobil = scanner.nextInt();

        if (jenisMobil.equalsIgnoreCase("a")) {
            biayaMobil = 175000;
            totalBiaya = (biayaMobil * lamaHariMobil) + (biayaSopir * lamaHariMobil);
            System.out.println("\nBiaya yang harus dibayar pelanggan adalah :");
            System.out.println("(note : bensin ditanggung penumpang)");
            System.out.println("Biaya Mobil = Rp." + (biayaMobil * lamaHariMobil) + ",-");
            System.out.println("Biaya Sopir = Rp." + (biayaSopir * lamaHariMobil) + ",-");
            System.out.println("Total Biaya = Rp." + totalBiaya + ",-");
        }else if (jenisMobil.equalsIgnoreCase("b")){
            biayaMobil = 250000;
            totalBiaya = (biayaMobil * lamaHariMobil) + (biayaSopir * lamaHariMobil);
            System.out.println("\nBiaya yang harus dibayar pelanggan adalah :");
            System.out.println("(note : bensin ditanggung penumpang)");
            System.out.println("Biaya Mobil = Rp." + (biayaMobil * lamaHariMobil) + ",-");
            System.out.println("Biaya Sopir = Rp." + (biayaSopir * lamaHariMobil) + ",-");
            System.out.println("Total Biaya = Rp." + totalBiaya + ",-");
        }else if (jenisMobil.equalsIgnoreCase("c")){
            biayaMobil = 225000;
            totalBiaya = (biayaMobil * lamaHariMobil) + (biayaSopir * lamaHariMobil);
            System.out.println("\nBiaya yang harus dibayar pelanggan adalah :");
            System.out.println("(note : bensin ditanggung penumpang)");
            System.out.println("Biaya Mobil = Rp." + (biayaMobil * lamaHariMobil) + ",-");
            System.out.println("Biaya Sopir = Rp." + (biayaSopir * lamaHariMobil) + ",-");
            System.out.println("Total Biaya = Rp." + totalBiaya + ",-");
            System.out.println("(note : bensin ditanggung penumpang)");
        }else {
            System.out.println("input tidak ditemukan");
        }
    }
}
