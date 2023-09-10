package com.tutorial;

import java.util.Scanner;

public class CetakAngka {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("masukkan nilai n = ");
        int nilai = scanner.nextInt();

        for (int i = 1; i <= nilai; i++) {
            for (int j = 1; j <= nilai; j++) {
                if (i == 1){
                    System.out.print(j + "  ");
                }else if (j == 1) {
                    System.out.print(i + "  ");
                }else if (j == nilai || i == nilai){
                    System.out.print("+  ");
                }else {
                    System.out.print("*  ");
                }
            }
            System.out.println();
        }


    }
}
