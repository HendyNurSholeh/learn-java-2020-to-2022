package com.tutorial;
import java.util.*;
public class Main {

    public static void main(String[] args) {
        //program untuk menjumlahkan angka dengan rentang
        Scanner userInput= new Scanner(System.in);
        int nilaiAwal,nilaiAkhir,total;
        System.out.print("masukan nilai awal = ");
        nilaiAwal = userInput.nextInt();
        System.out.print("masukan nilai akhir = ");
        nilaiAkhir = userInput.nextInt();

        total = 0;

        while (nilaiAwal <= nilaiAkhir){
            total = total + nilaiAwal;
            System.out.println("+"+nilaiAwal+" = "+total);
            nilaiAwal++;
        }


    }
}
