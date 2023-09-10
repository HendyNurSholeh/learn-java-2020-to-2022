package com.tutorial;
import java.util.Scanner;

public class Penjualan {
    static Scanner sc = new Scanner(System.in);
    static String[] arrayNama = new String[10];
    static String[] arrayKode = new String[10];
    static int[] arrayHarga = new int[10];
    static int[] arrayJumlah = new int[10];
    static int[] arrayTotal = new int[10];
    public static void main(String[] args) {
        String namaAdmin = inputAdmin();
        boolean exit = true;
        do {
            switch (pilihan()){
                case "1":
                    viewTransaksiPenjualan();
                    break;
                case "2":
                    transaksiPembayaran(namaAdmin);
                    exit = false;
                    break;
                case "3":
                    exit = false;
                    break;
            }
            System.out.print("\n");
        }while (exit);
    }

    static String inputAdmin(){
        System.out.print("Nama Admin : ");
        String namaAdmin = sc.nextLine();
        return namaAdmin;
    }

    static String pilihan(){
        System.out.println("1. Transaksi Penjualan");
        System.out.println("2. Transaksi Pembayaran");
        System.out.println("3. Exit");
        System.out.print("Piih menu transaksi : ");
        String input = sc.nextLine();
        return  input;
    }

    // TRANSAKSI PENJUALAN
    static void viewTransaksiPenjualan(){
        System.out.println("\nTransaksi Penjualan");
        System.out.print("Input jumlah barang : ");
        int jumlahBr = sc.nextInt();
        transaksiPenjualan(jumlahBr);
    }
    static void transaksiPenjualan(int jumlahBr){
        DataPenjualan dp = new DataPenjualan();
        for (int i = 0; i < arrayNama.length; i++) {
            if (arrayNama[i] == null) {
                for (int j = 0; j < jumlahBr; j++) {
                    System.out.println("Barang ke- " + j + 1);
                    System.out.print("Kode barang  : ");
                    sc.nextLine();
                    dp.setKodeBarang(sc.nextLine());
                    System.out.print("Nama barang  : ");
                    dp.setNamaBarang(sc.nextLine());
                    System.out.print("Harga barang : ");
                    dp.setHargaBarang(sc.nextInt());
                    System.out.print("Jumlah beli  : ");
                    dp.setJumlah(sc.nextInt());
                    sc.nextLine();
                    // memasukkan data kedalam array
                    arrayKode[i] = dp.getKodeBarang();
                    arrayNama[i] = dp.getNamaBarang();
                    arrayHarga[i] = dp.getHargaBarang();
                    arrayJumlah[i] = dp.getJumlah();
                    arrayTotal[i] = arrayHarga[i] * arrayJumlah[i];
                }
                break;
            }
        }
    }

    // TRANSAKSI PEMBAYARAN
    static void transaksiPembayaran(String namaAdmin){
        System.out.println("Transaksi Pembayaran");
        System.out.println("============================TOSERBA KOKO&KAJI GANTENG============================");
        System.out.println("Nama Admin : " + namaAdmin);
        System.out.println("=================================================================================");
        System.out.printf("No\t\tKode Barang\t\tNama Barang\t\t\tHarga Satuan\t\t\tJumlah Total Harga");
        System.out.println("\n===============================================================================");
        inputBarang();
    }
    static void inputBarang(){
        int totalPenjualan = 0;
        for (int i = 0; i < arrayNama.length; i++) {
            if (arrayNama[i] != null) {
                System.out.printf("%-7d %-15s %-19s %-17d %-5d %d\n"
                        , i + 1, arrayKode[i], arrayNama[i], arrayHarga[i], arrayJumlah[i], arrayTotal[i]);
                totalPenjualan += arrayTotal[i];
            }
        }
        System.out.println("\nTotal penjualan Rp.  " + totalPenjualan);
        isUangKurang(totalPenjualan);
    }
    static void isUangKurang(int totalPenjualan){
        boolean nominalKurang = true;
        int nominal = 0;
        do {
            System.out.print("Masukkan nominal bayar Rp.  ");
            nominal += sc.nextInt();
            if (nominal < totalPenjualan){
                System.out.println("Maaf nominal uang yang dibayarkan KURANG!");
            }else {
                int nominalKembalian = nominal - totalPenjualan;
                System.out.println("Nominal Kembalian Rp.  " + nominalKembalian);
                nominalKurang = false;
            }
        }while (nominalKurang);
    }


}
