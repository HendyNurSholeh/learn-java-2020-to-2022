package com.tutorial;

public class Main {

    public static void main(String[] args) {
//looping bersarang
        for (int i = 0; i <= 4; i++) {
            for (int j = 0; j <= 4; j++) {
                System.out.print("*  ");
            }
            System.out.print("\n");
        }
        System.out.print("\n");
        for (int i = 0; i <= 4; i++) {
            for (int j = 0; j <= 4; j++) {
                if (i >= j) {
                    System.out.print("*  ");
                }
            }
            System.out.print("\n");
        }
        System.out.print("\n");
        for (int i = 0; i <= 4; i++) {
            for (int j = 0; j <=4; j++) {
                if (j-i>=0) {
                    System.out.print("*  ");
                }else {
                    System.out.print("   ");
                }
            }
            System.out.print("\n");
        }
        System.out.print("\n");
        for (int i = 0; i <= 8; i++) {
            for (int j = 0; j <= 8; j++) {
                System.out.print("*  ");
                if(i==j){
                    break;
                }else if (i+j==8){
                    break;
                }
            }
            System.out.print("\n");
        }

    }
}
