package com.tutorial;
import java.util.*;
public class Main2 {
    public static  void  main(String[] args){
        Scanner inputUser = new Scanner(System.in);
        int f,f1,f2,n;
        System.out.print("masukan nilai ke- : ");
        n = inputUser.nextInt();

        f = 0;
        f1= 0;
        f2= 1;
        int i = 1;
        do {
            System.out.println("nilai ke "+i+" = "+f);
            f1=f2;
            f2=f;
            f=f1+f2;
            i++;
        }while(i<=n);

    }
}
