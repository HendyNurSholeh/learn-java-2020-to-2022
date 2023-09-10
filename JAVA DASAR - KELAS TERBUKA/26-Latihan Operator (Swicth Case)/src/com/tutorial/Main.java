package com.tutorial;
import java.util.*;
public class Main {

    public static void main(String[] args) {
        Scanner inputUser;
        inputUser = new Scanner(System.in);
        float a,b,hasil;
        String c;
        System.out.print("nilai a = ");
        a = inputUser.nextFloat();
        System.out.print("operator = ");
        c = inputUser.next();
        System.out.print("nilai b = ");
        b = inputUser.nextFloat();
        System.out.println("input user = "+a+" "+c+" "+b);
        switch (c){
            case ("+"):
                hasil = a + b;
                System.out.println("hasil = "+ hasil);
                break;
            case ("-"):
                hasil = a - b;
                System.out.println("hasil = "+ hasil);
                break;
            case ("*"):
                hasil = a * b;
                System.out.println("hasil = "+ hasil);
                break;
            case ("/"):
                hasil = a / b;
                System.out.println("hasil = "+ hasil);
                break;
            default:
                System.out.println("operator tidak tersedia");
        }
    }
}
