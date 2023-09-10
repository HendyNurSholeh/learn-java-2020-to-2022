package com.tutorial;

import java.util.Scanner;

public class AlgoritmaPenjumlahanApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Masukkan output : ");
        Integer input = scanner.nextInt();

        for (int i = 1; i <= input; i++) {
            for (int j = 1; j <= 3 ; j++) {
                System.out.printf("%d + %d = %d\n",i,j,(i+j));
            }
        }

    }
}
