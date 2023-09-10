package com.tutorial;
import java.util.*;
public class Main {
    public static void main(String[] args){

        // membuat sebuah objek untuk menangkap input dari user
        Scanner inputUser = new Scanner(System.in);

        // sebuah program sederhana untuk menebak angka
        int nilaiBenar = 9;
        int nilaiTebakan;
        boolean statusTebakan;

        System.out.print("masukan nilai tebakan anda : ");
        nilaiTebakan = inputUser.nextInt();
        System.out.println("niai tebakan anda adalah : "+ nilaiTebakan);

        // operasi logika
        statusTebakan = nilaiTebakan == nilaiBenar;
        System.out.println("tebakan anda : "+ statusTebakan);

        // operasi aljabar boolean (and/or)
        System.out.print("masukan angka dari 1 - 5 : ");
        nilaiTebakan = inputUser.nextInt();
        statusTebakan = nilaiTebakan>1 && nilaiTebakan<5;

        System.out.println("Tebakan anda : "+ statusTebakan);

    }
}
