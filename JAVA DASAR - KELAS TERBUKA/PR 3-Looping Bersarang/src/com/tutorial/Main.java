package com.tutorial;

public class Main {

    public static void main(String[] args) {

        int i = 1;
        while (i <= 5) {
            i++;
            int j = 1;
            while (j <= 5) {
                j++;
                if (j - i >= 0) {
                    System.out.print("*  ");
                } else
                    System.out.print("   ");
            }
            System.out.print("\n");
        }
        System.out.print("\n");
        int a = 1;
        while (a <= 5) {
            a++;
            int j = 1;
            while (j <= 5) {
                j++;
                if (j + a >= 8) {
                    System.out.print("*  ");
                } else
                    System.out.print("   ");
            }
            System.out.print("\n");

        }
        System.out.print("\n");
        int s = 1;
        while (s <= 9) {
            s++;
            int j = 1;
            while (j <= 5) {
                j++;
                if (s-j > 4) {
                    System.out.print("   ");
                } else if (s+j < 8) {
                    System.out.print("   ");
                }else {
                    System.out.print("*  ");
                }
            }

            System.out.print("\n");
        }

        System.out.print("\n");
        int b = 1;
        while (b <= 9) {
            b++;
            int j = 1;
            while (j <= 9) {
                j++;
                if (j+b < 8) {
                    System.out.print("   ");
                }else if (b-j >4){
                    System.out.print("   ");
                }else if (j-b > 4){
                    System.out.print("   ");
                }else if (j+b > 16){
                    System.out.print("   ");
                }else{
                    System.out.print("*  ");
                }
            }
            System.out.print("\n");
        }
    }
}