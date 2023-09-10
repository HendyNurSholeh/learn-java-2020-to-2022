package com.tutorial;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) {

        int[] arrayData = {0,1,2,3};

        Scanner userInput = new Scanner(System.in);
        System.out.print("data ke-:");
        int indexInput = userInput.nextInt();

        // Exception biasa
        System.out.println("Exception biasa");
        try{
            System.out.printf("data dari array ke-%d adalah %d\n\n",indexInput,arrayData[indexInput]);
        }catch (Exception e){
            System.out.println(e);
        }

        // Exception didalam fungsi
        System.out.println("\nException didalam fungsi");
        int data = ambilData(arrayData,indexInput);
        System.out.printf("data dari array ke-%d adalah %d\n\n",indexInput,data);

        // Exception throws by method
        System.out.println("Exception throws by method");
        int data2 =0;
        try {
            data2 = ambildata2(arrayData,indexInput);
        }catch (Exception e){
            System.out.println(e);
        }
        System.out.printf("data dari array ke-%d adalah %d\n\n",indexInput,data2);



        System.out.println("\n\nini adalah akhir program");

    }
    private static int ambilData(int[]arrayData,int indexInput){
        int hasil = 0;
        try{
            hasil = arrayData[indexInput];
        }catch (Exception e){
            System.out.println(e);
        }
        return hasil;
    }
    private static int ambildata2(int []arrayData,int indexInput)throws Exception{
        int hasil = arrayData[indexInput];
        return hasil;

    }

}
