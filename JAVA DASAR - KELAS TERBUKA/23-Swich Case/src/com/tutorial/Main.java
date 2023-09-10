package com.tutorial;
import java.util.*;
public class Main {

    public static void main(String[] args) {
	// switch case

        String input;

        Scanner inputUser = new Scanner(System.in);

        System.out.print("panggil nama: ");
        input = inputUser.next();

        // ekspresi berupa satuan (int,long,byte,short), String, atau enum
        switch (input){
            case "hendy":
                System.out.println("saya hendy hadirrr");
                break;
            case "randi":
                System.out.println("saya randi  hadir");
                break;
            default:
                System.out.println("tidak hadir");
        }
        System.out.println("selesai");


    }
}
