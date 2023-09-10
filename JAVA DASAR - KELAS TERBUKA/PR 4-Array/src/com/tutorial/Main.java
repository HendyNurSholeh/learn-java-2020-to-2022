package com.tutorial;
import java.util.Arrays;
public class Main {

    public static void main(String[] args) {
        // sort kebalik
        System.out.println("\n Sort Kebalik");
        int [] array1 = {5,1,2,4,3,7,6,8,9};
        printArray(array1);// sebelum sort
        Arrays.sort(array1);
        printArray(array1);// sesudah sort
        sort(array1);// sort kebalik

        // cara menjumlahkan array
        System.out.println("\n menjumlahkan array");
        int [] array2 = {2,8,4,1,6,7};
        int [] array3 = {3,12,4,12,1,1,};
        printArray(array2);
        printArray(array3);
        tambahArray(array2,array3);

        // menggabungkan array
        System.out.println("\n menggabungkan array");
        int [] array4 = {1,4,3,5,6,7};
        int [] array5 = {11,2,4,5,7,8,5,4};
        printArray(array4);
        printArray(array5);
        gabungArray(array4,array5);

    }
    private static void printArray(int [] arrayy){

        System.out.println(Arrays.toString(arrayy));
    }
    private static void sort(int []array1){
        int [] newArray = new int [array1.length];
        for (int i=0;i<newArray.length;i++){
            newArray [i] = array1[array1.length-(i + 1)];
        }
        System.out.println(Arrays.toString(newArray));
    }
    private static void tambahArray(int [] array1,int[] array2){
        int []newArray = new int[array1.length];
        for (int i = 0;i < newArray.length;i++){
            newArray [i] = array1[i] + array2[i];
        }
        System.out.println(Arrays.toString(newArray));
    }
    private static void gabungArray(int[] array1,int []array2){
        int [] newArray = new int[array1.length+array2.length ];
        for (int i =0;i<newArray.length;i++){
            if (i < array1.length){
                newArray[i]=array1[i];
            }else {
                newArray[i]=array2[i - (array1.length)];
            }
        }
        System.out.println(Arrays.toString(newArray));
    }
}
