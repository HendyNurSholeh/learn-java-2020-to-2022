package com.tutorial;
import java.util.*;
public class Main {

    public static void main(String [] args){

        Scanner userInput = new Scanner(System.in);
        System.out.print("masukan nilai = ");
        int nilai = userInput.nextInt();
        System.out.println("anda memasukan nilai = "+nilai);

        printNilai(nilai);
        System.out.println("jumlah = "+jumlahNilai(nilai));
        System.out.println("faktorial dari "+nilai+" = "+faktorial(nilai));
    }

    private static void printNilai(int parameter){
        System.out.println("nilai = "+ parameter);
        if (parameter==0){
            return;
        }
        parameter --;
        printNilai(parameter);

    }
    private static int jumlahNilai(int parameter){
        if(parameter==0){
            return parameter;
        }
        return parameter+ jumlahNilai(parameter-1);
    }
    private static int faktorial(int parameter){
        if (parameter ==1) {
            return parameter;
        }
        return parameter * faktorial(parameter - 1);
    }
}