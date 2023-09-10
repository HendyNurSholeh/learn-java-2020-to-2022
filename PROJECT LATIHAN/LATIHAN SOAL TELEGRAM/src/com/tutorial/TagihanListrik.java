package com.tutorial;
import java.util.Scanner;

public class TagihanListrik {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Masukan besar pemakaian kwh :");
        int besarKwh = scanner.nextInt();

        if (besarKwh <= 100) { // golongan C
            int abonemen = 50000;
            int hargaPerKwh = 2250 * besarKwh;
            int totalBiaya = abonemen + hargaPerKwh;
            int pajak = totalBiaya * 15 / 100;
            System.out.println("---GOLONGAN C---");
            System.out.println("Abomen = Rp." + abonemen);
            System.out.println("Harga per kwh = Rp." + hargaPerKwh);
            System.out.println("Pajak = Rp." + pajak);
        } else if (besarKwh <= 200) { // golongan B
            int abonemen = 35000;
            int hargaPerKwh = 1750 * besarKwh;
            int totalBiaya = abonemen + hargaPerKwh;
            int pajak = totalBiaya * 10 / 100;
            System.out.println("---GOLONGAN B---");
            System.out.println("Abomen = Rp." + abonemen);
            System.out.println("Harga per kwh = Rp." + hargaPerKwh);
            System.out.println("Pajak = Rp." + pajak);
        }else if (besarKwh <= 300) { // golongan A
            int abonemen = 20000;
            int hargaPerKwh = 15000 * besarKwh;
            int totalBiaya = abonemen + hargaPerKwh;
            int pajak = totalBiaya * 5 / 100;
            System.out.println("---GOLONGAN A---");
            System.out.println("Abomen = Rp." + abonemen);
            System.out.println("Harga per kwh = Rp." + hargaPerKwh);
            System.out.println("Pajak = Rp." + pajak);
        }
    }
}
