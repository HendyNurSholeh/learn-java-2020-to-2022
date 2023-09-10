package com.tutorial;
import jdk.swing.interop.SwingInterOpUtils;

import java.util.Scanner;
public class Main {

    public static void main(String[] args) {

        int hasil;

        // Menggunakan pengelompokan operasi dengan ()
        hasil = 5 * (2 + 10);
        System.out.println(hasil);

        Scanner userInput = new Scanner(System.in);

        System.out.println("MENGHITUNG PERSAMAAN KUADRAT");
        int m,x,c;
        System.out.print("gradient M = ");
        m = userInput.nextInt();
        System.out.print("nilai X = ");
        x = userInput.nextInt();
        System.out.print("bias c = ");
        c = userInput.nextInt();
        hasil = m*x*x+c;
        System.out.println("hasil = "+ hasil);


    }
}
