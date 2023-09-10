package com.tutorial;

import java.util.Formatter;

public class Main {

    public static void main(String[] args) {

        String nama = "udin";
        int umur = 17;

        // output : Nama saya adalah udin, umur saya adalah 17
        System.out.println("nama saya adalah "+nama+", umur saya adalah "+umur);

        // cara lainnya adalah dengan format string
        System.out.printf("nama saya adalah %s, umur saya adalah %d",nama,umur);

        // conversion : f=floting point, d=integer, s=string, c=character, b=boolean
        // struktur format = %[argumen_index$][flags][width][.precision]conversion

        // 1.[argumen_index$]
        System.out.println("\n\n1. [argumen_index$]");
        // udin wahai udin kemana saja kamu udin
        System.out.printf("%1$s wahai %1$s kemana saja kamu %1$s\n",nama);
        // umur udin berapa ?, udin menjawab: 17, wah masih muda juga ya umur nya 17
        System.out.printf("\numur %1$s berapa ?, \nudin menjawab: %2$d, \nwah masih muda juga ya umurnya %2$d",nama,umur);

        // 2.[flags] ("+", "-")
        System.out.println("\n\n2. [flags]");
        int int1 = 5;
        int int2 = 8;
        int hasil = int1 - int2;
        System.out.printf("%d - %d = %+d",int1,int2,hasil);

        // 3.[width]
        System.out.println("\n\n3. [width]");
        int int3 = 1000;
        System.out.println("INTEGER");
        System.out.printf("%d\n",int3);
        System.out.printf("%6d\n",int3);
        System.out.printf("%-6d\n",int3);// flags = "-", artinya rata kiri
        System.out.printf("%+6d\n",int3);// flags akan mengambil slot di dalam format
        System.out.printf("%+-6d\n",int3);// flags bisa digabungkan
        System.out.printf("%10d\n",int3);
        System.out.printf("% 10d\n",int3);
        System.out.printf("%010d\n",int3);// flags = "0", kita tambahkan leading "0" didepannya
        System.out.printf("+%010d\n",int3);// menambahkan + didepan nol
        System.out.printf("%,10d\n",int3);// setiap 1000 akan ada koma (1,000)

        System.out.println("\nFLOATING POINT");
        float float1 = 1.476f;
        System.out.printf("%f\n",float1);
        System.out.printf("%+12f\n",float1);// floating point akan mengambil width 6 desimal

        // [.precision]
        System.out.println("\n4. [.precision]");
        float float2 = 15.476f;
        System.out.printf("%f\n",float2);
        System.out.printf("%.2f\n",float2);
        System.out.printf("%+012.1f\n",float2);// gabungkan dengan width dan flag

        // contoh
        System.out.println("\n contoh soal");
        String nama2 = "Ucup";
        float float3 = 3.7167617612f;
        //struktur format = %[argumen_index$][flags][width][.precision]conversion
        System.out.printf("IPK %1$s berapa?,\n%1$s: saya dapet %2$+5.2f",nama2,float3);

        // kesimpulan

        // save format ini kedalam variabel string
        String info = "\nstring biasa --> nama: "+nama2+", IPK: "+float3;
        System.out.println(info);

        String info_format = String.format("string format --> nama: %s, IPK: %.2f",nama2,float3);
        System.out.println(info_format);

        // save format ke dalam string builder

        StringBuilder builder_info = new StringBuilder();
        Formatter formatbuilder = new Formatter(builder_info);

        formatbuilder.format("string builder format --> nama: %s, IPK: %.2f",nama2,float3);
        System.out.println(builder_info);

    }
}
