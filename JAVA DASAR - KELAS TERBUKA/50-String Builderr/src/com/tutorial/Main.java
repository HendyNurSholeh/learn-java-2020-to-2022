package com.tutorial;
import java.lang.StringBuilder;
public class Main {

    public static void main(String[] args) {

        StringBuilder builder = new StringBuilder("halo");
        printData(builder);

        // append
        builder.append(" semuanya");
        printData(builder);

        builder.append( " warga surabaya");
        printData(builder);

        // insert
        builder.insert(19," kota");
        printData(builder);

        // delete
        builder.delete(20,25);
        printData(builder);

        // setCharAt
        builder.setCharAt(14,'W');
        printData(builder);

        // replace
        builder.replace(20,28,"bandung");
        printData(builder);

        // casting menjadi string
        String kalimat = builder.toString();
        System.out.println(kalimat);
        int addressString = System.identityHashCode(kalimat);
        System.out.println("address = "+Integer.toHexString(addressString));


    }
    private static void printData (StringBuilder dataBuilder){
        System.out.println("data = "+dataBuilder);
        System.out.println("panjang = "+dataBuilder.length());
        System.out.println("kapasitas = "+dataBuilder.capacity());

        int addressBuilder = System.identityHashCode(dataBuilder);
        System.out.println("address = "+Integer.toHexString(addressBuilder));
        System.out.print("\n");
    }
}
