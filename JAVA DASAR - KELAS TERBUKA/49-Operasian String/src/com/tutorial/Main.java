package com.tutorial;

import java.util.Locale;
import java.util.Scanner;
//import java.lang.String;

public class Main {

    public static void main(String[] args) {
        String kalimat = "saya suka makan pisang";

        // mengambil komponen dari string
        System.out.println("Mengambil komponen dari string menggunakan charAt");
        System.out.println(kalimat.charAt(5));

        // substring
        System.out.println("\nMengambil komponen dengan range menggunakan substring");
        String kata = kalimat.substring(10,15);
        System.out.println(kata);

        // concatenation (concat)
        System.out.println("\nCara menambah/concat kalimat dengan membuat string baru ");
        String kalimat2 = kata + " bakwan";
        System.out.println(kalimat2);
        kata = kata + " cireng";
        System.out.println(kata);

        // concat dengan string
        System.out.println("\nConcat string dengan integer dengan cara membuat string baru");
        int jumlah = 20;
        String kalimat3 = kata + " "+ jumlah;//casting
        System.out.println(kalimat3);

        // lowercase dan uppercase
        System.out.println("\nMembuat kalimat besar atau kecil dengan upper dan lower");
        System.out.println(kalimat.toUpperCase(Locale.ROOT));
        System.out.println(kalimat.toLowerCase(Locale.ROOT));


        // replace
        System.out.println("\nMengubah kalimat menggunakan replace dengan membuat string baru");
        String kalimat4 = kalimat.replace("pisang","combro");
        System.out.println(kalimat);
        System.out.println(kalimat4);

        // compare
        System.out.println("\nCompare sesuai jarak alfabet");
        String motor1 = "royal enfield himalaya";
        String motor2 = "kawasaki w175";
        System.out.println(motor1.compareTo(motor2));//klmnopqr
        System.out.println(motor2.compareTo(motor1));

        String gorengan1 = "bakwan";
        String gorengan2 = "bala-bala";//k l
        System.out.println(gorengan1.compareTo(gorengan2));
        System.out.println(gorengan2.compareTo(gorengan1));

        // equality / persamaan
        System.out.println("\nMembedakan kalimat string sama atau tidak dengan equals");
        //String kataInput = "test";// ini ada di string pool
        String kataInput = new String("test");// ini bukan string literal, dan tidak berada di string pool
        String kataTest = "test";// ini juga ada di string pool
        System.out.println("persamaan pada lokasi string pool");
        if (kataInput.equals(kataTest)){
            System.out.println("sama");
        }else{
            System.out.println("tidak sama");
        }

        Scanner userInput = new Scanner(System.in);
        System.out.print("mengambil input dari user :");
        kataInput = userInput.next();//tidak di string pool
        System.out.println("ini adalah input user: "+kataInput);
        if (kataInput.equals(kataTest)){
            System.out.println("sama");
        }else{
            System.out.println("tidak sama");
        }
    }
}
