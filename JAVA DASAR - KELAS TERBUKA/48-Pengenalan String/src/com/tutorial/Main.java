package com.tutorial;
import java.util.Arrays;
public class Main {

    public static void main(String[] args) {
        // membuat string
        String kataString = "hallo";
        char []kataChar = {'h','a','l','l','o'};
        System.out.println("");

        // menampilkan string
        System.out.println(kataString);
        System.out.println(Arrays.toString(kataChar));
        System.out.println("");

        // mengakses komponen dari string
        System.out.println("komponen pertama dari char[] = "+kataChar[3]);
        System.out.println("komponen pertama dari string = "+kataString.charAt(3));
        System.out.println("");

        // merubah komponen dari string
        // itu tidak bisa...kenapa?, karena string di java itu immutable
        kataChar[0] = 'c';
        // kataString(0) = "c"; //eror
        // kataString.charAt(0) = "c"; //eror
        System.out.println(kataChar);
        System.out.println("");

        // kita bisa merubah komponen secara tidak langsung
        printAddress("kataString ",kataString);
        kataString="c"+kataString.substring(1,5);
        printAddress("kataString ",kataString);
        System.out.println("");

        // jika kita membuat 2 buah string denggan kata yang sama maka
        // address dari kedua kata tersebut adalah sama
        String str1 = "test";
        String str2 = "test";
        printAddress("string 1 ",str1);
        printAddress("string 2 ",str2);
        // jika kita mengambil data menggunakan substring atau method lainnya
        // maka addressnya tetap berbeda karna tidak otomatis terbaca
        String str3 = "testing";
        str3 = str3.substring(0,4);
        printAddress("string 3 ",str3);

        // KESIMPULAN
        // 1. string di java itu immutable
        // 2. string yang berada di string pool itu akan reusable,
        //    memorynya lebih efisien
        // 3. membuat string dengan method baru, maka dia akan ditaruh
        //    di memory lain bukan di string pool

        // lihat lebih dalam
        System.out.println("");
        String a = new String("hallo") ;
        printAddress("new string ",a);
        // addres tidak sama dengan kataString yang ada di atas
        // karna dibuat menggunakan campur tangan method lainnya

        


    }
    private static void printAddress(String nama,String data){
        int address = System.identityHashCode(data);
        System.out.println(nama + " = "+data+"\t|| address = "+ Integer.toHexString(address));
    }
}
