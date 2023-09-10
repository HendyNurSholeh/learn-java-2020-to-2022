package com.tutorial;

import java.util.Scanner;

public class InputNilai {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);


        int array[] = new int[3];

        System.out.print("Nama depan : ");
        String namaDepan = cin.nextLine();

        System.out.print("Nama belakang : ");
        String namaBelakang = cin.nextLine();

        System.out.print("Nilai TUGAS : ");
        array[0] = cin.nextInt();

        System.out.print("Nilai UTS : ");
        array[1] = cin.nextInt();

        System.out.print("Nilai UAS : ");
        array[2] = cin.nextInt();

        System.out.println("\nOutput : ");
        String nama = namaDepan + " " + namaBelakang;
        System.out.println("Nama        : " + nama);
        System.out.println("Nilai TUGAS : " + array[0]);
        System.out.println("Nilai UTS   : " + array[1]);
        System.out.println("Nilai UAS   : " + array[2]);

        int rata2 = (array[0] + array[1] +array[2]) / 3;
        System.out.println("Nilai rata2 : " + rata2);

            if (rata2 > 85){
                System.out.println("Grade       : A");
            }else if(rata2 > 75){
                System.out.println("Grade       : B");
            }else if (rata2 > 60) {
                System.out.println("Grade       : C");
            }else if (rata2 < 60){
                System.out.println("Grade       : D");
            }else if (rata2 < 50){
                System.out.println("Grade       : E");

        }





    }
}
