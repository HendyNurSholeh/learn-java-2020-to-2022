package com.tutorial;
import java.util.Arrays;
public class Main {

    public static void main(String[] args) {
        int [] array1 = {3,5,2,4,6,48,9};
        int [] array2 = {2,1,4,6,8,7,6};
        // menjumlahkan array1 dan array2
        System.out.println("\nMenjumlahkan array1 dan array2");
        printArray("array 1 = ",array1);
        printArray("array 2 = ",array2);
        printArray("hasil   = ",jumlahArray(array1,array2));

        // menggabungkan array1 dan array2
        System.out.println("\nMenggabungkan array1 dan array");
        printArray("array 1 = ",array1);
        printArray("array 2 = ",array2);
        printArray("hasil   = ",gabungArray(array1,array2));

        // sort kebalik
        System.out.println("\nsort kebalik");
        printArray("array 1 = ",array1);
        Arrays.sort(array1);
        printArray("array 1 = ",array1);
        sortKebalik(array1);
        printArray("hasil   = ",array1);

        // sort kebalik versi 2
        System.out.println("\nsort kebalik versi 2");
        printArray("array 1 = ",array1);
        Arrays.sort(array1);
        printArray("array 1 = ",array1);
        sortKebalikV2(array1);
        printArray("array 1 = ",array1);
    }
    private static void printArray(String tulis,int [] array){
        System.out.println(tulis+ Arrays.toString(array));
    }
    private static int [] jumlahArray(int [] array1,int []array2) {
        int[] jumlah = new int[array1.length];
        for (int i = 0; i < jumlah.length; i++) {
            jumlah[i] = array1[i] + array2[i];
        }
        return jumlah;
    }
    private static int[] gabungArray(int []array1,int [] array2) {
        int[] gabung = new int[array1.length + array2.length];
        for (int i = 0; i < array1.length; i++) {
            gabung[i] = array1[i];
        }
        for (int i = 0; i < array2.length; i++) {
            gabung[array1.length + i] = array2[i];
        }
        return gabung;
    }
    private static void sortKebalik(int[] array1) {
        int[] buffer = Arrays.copyOf(array1, array1.length);
        for (int i = 0; i < buffer.length; i++) {
            array1[i] = buffer[buffer.length - (i + 1)];
        }
    }
    private static void sortKebalikV2(int[] array1) {
        int[] buffer = Arrays.copyOf(array1, array1.length);
        for (int i = 0; i < buffer.length/2; i++) {
            array1[i] = buffer[buffer.length - (i + 1)];
            array1[buffer.length - (i + 1)] =  buffer[i];
        }
    }
}
