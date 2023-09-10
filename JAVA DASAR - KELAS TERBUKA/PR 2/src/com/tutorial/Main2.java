package com.tutorial;
import java.util.*;
public class Main2 {
    public static void main(String[] args){
        //membuat program penjumlahan dengan rentan menggunakan do while
        Scanner userInput= new Scanner(System.in);
        int nilaiAwal,nilaiAkhir,total;

        System.out.print("masukan nilai awal = ");
        nilaiAwal = userInput.nextInt();
        System.out.print("masukan nilai akhir = ");
        nilaiAkhir = userInput.nextInt();

        total = 0;

        do {
            total = total + nilaiAwal;
            System.out.println("+"+nilaiAwal+" = "+total);
            nilaiAwal ++;
        }while (nilaiAwal <= nilaiAkhir);

    }
}
