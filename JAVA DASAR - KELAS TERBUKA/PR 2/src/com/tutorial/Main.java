package com.tutorial;
import java.util.*;
public class Main {
    //membuat program penjumlahan dengan rentan menggunakan for loop
    public static void main(String[] args) {
        Scanner userInput=new Scanner(System.in);
        int nilaiAwal,nilaiAkhir,total;
        System.out.print("masukan nilai awal = ");
        nilaiAwal = userInput.nextInt();
        System.out.print("masukan nilai akhir = ");
        nilaiAkhir = userInput.nextInt();

        for ( total = 0;nilaiAwal<=nilaiAkhir;){
            total = total + nilaiAwal;
            System.out.println("+"+nilaiAwal+" = "+total);
            nilaiAwal++;
        }

    }
}
