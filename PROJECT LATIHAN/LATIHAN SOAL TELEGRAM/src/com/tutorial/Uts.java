package com.tutorial;

import java.util.*;

public class Uts {
    public static void main(String[] args) {
        // Menyimpan usia mahasiswa-mahasiswa ke array
        int[] arrayUsiaMahasiswa = {21,19,20,22,17,17,18};

        // Menginput mahasiswa yang usia >19
        int k = 1;
        System.out.println("Mahasiswa yang berusia > 19 tahun:");
        for(int mahasiswa : arrayUsiaMahasiswa){
            if (mahasiswa > 19){
                System.out.println("Mahasiswa ke-" + k);
            }
            k++;
        }

        // Menghitung nilai rata-rata usia semua mahasiswa
        int totalUsia = 0;
        for (int usia : arrayUsiaMahasiswa){
            totalUsia = totalUsia + usia;
        }
        int rataRataUsia = totalUsia / arrayUsiaMahasiswa.length;
        System.out.println("\nUsia Rata-rata mahasiswa adalah " + rataRataUsia +" tahun");

        // Program matrix
        System.out.println("Menampilkan Matriks");
        System.out.println("-------------------");

        Scanner scanner = new Scanner(System.in);
        System.out.print("Masukan jumlah baris (max.10) = ");
        int jumlahBaris = scanner.nextInt();
        System.out.print("Masukan jumlah kolom (max.10) = ");
        int jumlahKolom = scanner.nextInt();

        List<Integer> listNumber = new ArrayList<>();
        for (int i = 0; i < 10; i++){
            Collections.shuffle(listNumber);
            for (int j = 0; j<10; j++){
                listNumber.add(j);
            }
        }

        System.out.println("---------------------------------------------");
        for (int i = 1; i<=jumlahBaris; i++){
            for (int j = 1; j<=jumlahKolom; j++){
                System.out.println("Elemen (" + i + "." + j + ") = " + listNumber.get(i*j));
            }
        }
        System.out.println("---------------------------------------------");
        System.out.println("Matriks yang di input =");
        for (int i = 1; i<=jumlahBaris; i++){
            for (int j = 1; j<=jumlahKolom; j++){
                System.out.print(listNumber.get(i*j) + "  ");
            }
            System.out.println();
        }

    }
}
