package com.tutorial;
import java.util.Arrays;
public class Main {

    public static void main(String[] args) {

        int [] arrayAngka1={1,2,3,4,5};

        // merubah array menjadi string
        System.out.println("\n Merubah array menjadi string\n ======================");
        printArray(arrayAngka1);

        // Mengkopi array
        System.out.println("\n Mengkopi array\n ======================");
        int[] arrayAngka2 = new int[5];
        printArray(arrayAngka1);
        printArray(arrayAngka2);
        System.out.println("\n Mengkopi dengan loop");
        for (int i = 0; i<arrayAngka1.length;i++){
            arrayAngka2 [i] = arrayAngka1[i];
        }
        printArray(arrayAngka1);
        System.out.println(arrayAngka1);
        printArray(arrayAngka2);
        System.out.println(arrayAngka2);
        System.out.println("\n Mengkopi dengan copyOf");
        int[] arrayAngka3= Arrays.copyOf(arrayAngka1, 5);
        printArray(arrayAngka1);
        System.out.println(arrayAngka1);
        printArray(arrayAngka3);
        System.out.println(arrayAngka3);
        System.out.println("\n Mengkopi dengan copyOfRange ");
        int [] arrayAngka4 = Arrays.copyOfRange(arrayAngka1,2,5) ;
        printArray(arrayAngka1);
        System.out.println(arrayAngka1);
        printArray(arrayAngka4);
        System.out.println(arrayAngka4);

        // fill array
        System.out.println("\n Fill array\n ======================");
        int [] arrayAngka5 = new int[10];
        printArray(arrayAngka5);
        Arrays.fill(arrayAngka5,1);
        printArray(arrayAngka5);

        // komparasi array
        System.out.println("\n Komparasi array\n ======================");
        int [] arrayAngka6 = {1,2,3,4,5};
        int [] arrayAngka7 = {1,2,3,4,5};

        System.out.println("\n membandingkan 2 array apakah sama/tidak");
        System.out.println(Arrays.equals(arrayAngka6,arrayAngka7));
        if (Arrays.equals(arrayAngka6,arrayAngka7)){
            System.out.println("array ini sama");
        }else{
            System.out.println("array ini beda");
        }

        System.out.println("\n mengecek mana array yang lebih besar");
        System.out.println(Arrays.compare(arrayAngka6,arrayAngka7));

        System.out.println("\n mengecek mana index yang berbeda");
        System.out.println(Arrays.mismatch(arrayAngka6,arrayAngka7));

        // sort array
        System.out.println("\n Sort array\n ======================");
        int [] arrayAngka8={5,4,3,6,8,9,6,5,4};
        Arrays.toString(arrayAngka8);
        printArray(arrayAngka8);
        Arrays.sort(arrayAngka8);
        printArray(arrayAngka8);

        // search array
        System.out.println("\n Search array\n ======================");
        int nyariAngka = Arrays.binarySearch(arrayAngka8,8);
        System.out.println(nyariAngka);



    }
    private static void printArray(int[] dataArray){
        System.out.println("array = "+Arrays.toString(dataArray));

    }
}
