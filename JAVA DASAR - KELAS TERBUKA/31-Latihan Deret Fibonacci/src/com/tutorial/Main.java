package com.tutorial;
import java.util.*;
public class Main {

    public static void main(String[] args) {
	// menghitung deret fibonacci ke-n
        Scanner userInput = new Scanner(System.in);
        int n,f,f1,f2;
        System.out.print("mengambil nilai fibonacci ke- : ");
        n = userInput.nextInt();

        f=0;
        f2 = 0;
        f1 = 1;
        int i =1;
        while (i<=n){
            System.out.println("nilai ke- "+i+" = "+f);
            f2=f1;
            f1=f;
            f=f1+f2;

            i++;
        }

    }
}
