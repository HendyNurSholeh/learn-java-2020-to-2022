package com.tutorial;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        int [] array = {0,1,2,3};
        Scanner userInput=new Scanner(System.in);
        System.out.print("nilai array ke : ");
        int index = userInput.nextInt();

        // exceptin handling (try,catch,finally)
        System.out.println("ini adalah handling out of bound");
        try {
            System.out.printf("index ke %d, adalah %d\n", index, array[index]);
        }catch (Exception e){
            System.out.println(e);
        }

        // runtime eror jika file tidak ada
        System.out.println("\nIO not found");
        FileInputStream fileInput = null;
        try{
            fileInput = new FileInputStream("input.txt");
        }catch (IOException e){
            System.out.println(e);
        }

        // menggabungkan 2 exception
        System.out.println("\nmenggabungkan  buah exception");
        try{
            System.out.printf("index ke %d, adalah %d\n", index, array[index]);
            fileInput = new FileInputStream("input.txt");
        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println("index yang anda yang masukkan tidak sesuai dengan jumlah arrray");
        }catch(IOException e) {
            System.out.println("file tidak ditemukan");
        }

            // finally
        System.out.println("\nmenambahkan finally");
        try{
            System.out.printf("index ke %d, adalah %d\n", index, array[index]);
                fileInput = new FileInputStream("input.txt");
        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println("index yang anda yang masukkan tidak sesuai dengan jumlah arrray");
        }catch(IOException e) {
            System.out.println("file tidak ditemukan");
        }finally {
            System.out.println("finally");
        }
        System.out.println("\nini adalah akhir dari program");
    }
}
