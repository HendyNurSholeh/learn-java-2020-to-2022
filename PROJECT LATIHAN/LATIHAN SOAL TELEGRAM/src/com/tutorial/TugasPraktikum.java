package com.tutorial;
import java.util.Scanner;

public class TugasPraktikum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n------- MENGHITUNG MATRIKS 2 X 2 --------");
        System.out.println("1. Penjumlahan");
        System.out.println("2. Perkalian");
        System.out.println("3. Selesai");
        System.out.print("Masukan pilihan anda [1/2/3] ? ");
        String pilihan = scanner.next();

        switch (pilihan){
            case "1":
                System.out.println("\n----- MENENTUKAN NILAI MATRIKS -----");
                //MEMASUKKAN NILAI MATRIKS A KE DALAM ARRAY
                System.out.println("Masukan nilai matriks A");
                int[][] matriksA = new int[2][2];
                for (int i = 0; i < 2; i++) {
                    for (int j = 0; j < 2; j++) {
                        System.out.print("Matriks " + (i+1) + "." + (j+1) + " = ");
                        matriksA[i][j] = scanner.nextInt();
                    }
                }
                //MENAMPILKAN MATRIKS A
                System.out.println("MATRIKS A");
                for (int i = 0; i < 2; i++) {
                    for (int j = 0; j < 2; j++) {
                        System.out.print("  " + matriksA[i][j]);
                    }
                    System.out.println();
                }
                //MEMASUKKAN NILAI MATRIKS B KE DALAM ARRAY
                System.out.println("\nMasukan nilai matriks B");
                int[][] matriksB = new int[2][2];
                for (int i = 0; i < 2; i++) {
                    for (int j = 0; j < 2; j++) {
                        System.out.print("Matriks " + (i+1) + "." + (j+1) + " = ");
                        matriksB[i][j] = scanner.nextInt();
                    }
                }
                //MENAMPILKAN MATRIKS B
                System.out.println("MATRIKS B");
                for (int i = 0; i < 2; i++) {
                    for (int j = 0; j < 2; j++) {
                        System.out.print("  " + matriksB[i][j]);
                    }
                    System.out.println();
                }

                //MENGHITUNG TOTAL
                int[][] total = new int[2][2];
                for (int i = 0; i < 2; i++) {
                    for (int j = 0; j < 2; j++) {
                        total[i][j] = matriksA[i][j] + matriksB[i][j];
                    }
                }
                //MENAMPILKAN TOTAL
                System.out.println("\n----- PENJUMLAHAN -----");
                System.out.println("matriks A + matriks B =");
                for (int i = 0; i < 2; i++) {
                    for (int j = 0; j < 2; j++) {
                        System.out.print("  " + total[i][j]);
                    }
                    System.out.println();
                }
                break;

            case "2":
                System.out.println("\n----- MENENTUKAN NILAI MATRIKS -----");
                //MEMASUKKAN NILAI MATRIKS A KE DALAM ARRAY
                System.out.println("Masukan nilai matriks A");
                int[][] matrikssA = new int[2][2];
                for (int i = 0; i < 2; i++) {
                    for (int j = 0; j < 2; j++) {
                        System.out.print("Matriks " + (i+1) + "." + (j+1) + " = ");
                        matrikssA[i][j] = scanner.nextInt();
                    }
                }
                //MENAMPILKAN MATRIKS A
                System.out.println("MATRIKS A");
                for (int i = 0; i < 2; i++) {
                    for (int j = 0; j < 2; j++) {
                        System.out.print("  " + matrikssA[i][j]);
                    }
                    System.out.println();
                }
                //MEMASUKKAN NILAI MATRIKS B KE DALAM ARRAY
                System.out.println("\nMasukan nilai matriks B");
                int[][] matrikssB = new int[2][2];
                for (int i = 0; i < 2; i++) {
                    for (int j = 0; j < 2; j++) {
                        System.out.print("Matriks " + (i+1) + "." + (j+1) + " = ");
                        matrikssB[i][j] = scanner.nextInt();
                    }
                }
                //MENAMPILKAN MATRIKS B
                System.out.println("MATRIKS B");
                for (int i = 0; i < 2; i++) {
                    for (int j = 0; j < 2; j++) {
                        System.out.print("  " + matrikssB[i][j]);
                    }
                    System.out.println();
                }

                //MENGHITUNG TOTAL
                int[][] totall = new int[2][2];
                int templat;
                for (int i = 0; i < 2; i++) {
                    for (int j = 0; j < 2; j++) {
                        templat = 0;
                        for (int k = 0; k < 2; k++) {
                            templat += matrikssA[i][k] * matrikssB[k][j];
                        }
                        totall[i][j] = templat;
                    }
                }
                //MENAMPILKAN TOTAL
                System.out.println("\n----- PERKALIAN -----");
                System.out.println("matriks A x matriks B =");
                for (int i = 0; i < 2; i++) {
                    for (int j = 0; j < 2; j++) {
                        System.out.print("  " + totall[i][j]);
                    }
                    System.out.println();
                }
                break;
            case  "3":
                System.out.println("PROGRAM SELESAI");
                break;
            default:
                System.out.println("Pilihan anda tidak sesuai\nProgram selesai");
        }
    }
}
