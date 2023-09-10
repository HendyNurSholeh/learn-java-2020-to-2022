package com.tutorial;
import java.util.*;
public class Main {

    public static void main(String[] args) {
        Scanner inputUser = new Scanner(System.in);
        // ternary operator
        int input,x;
        System.out.print("masukan angka = ");
        input = inputUser.nextInt();

        // variable x = ekspresi ? statement_true : statement_false
        x = (input == 5) ? (input*input) : (input/1);
        System.out.println("hasilnya : "+ x);

    }
}
