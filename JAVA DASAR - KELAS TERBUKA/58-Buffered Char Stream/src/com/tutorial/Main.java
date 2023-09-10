package com.tutorial;

import java.io.*;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
	    // Membaca file dulu
        FileReader fileInput = new FileReader("input.txt");
        BufferedReader bufferedReader = new BufferedReader(fileInput);
        bufferedReader.mark(200);

        // Membaca ke dalam string
        String data = bufferedReader.readLine();
        System.out.println(data);

        // Membaca ke dalam char
        bufferedReader.reset();
        char [] dataChar = new char[17];
        bufferedReader.read(dataChar,0,17);
        System.out.println(Arrays.toString(dataChar));

        // Membaca baris
        bufferedReader.reset();
        System.out.println(bufferedReader.readLine());
        System.out.println(bufferedReader.readLine());

        // Menulis file
        bufferedReader.reset();
        FileWriter fileOutput = new FileWriter("output.txt");
        BufferedWriter bufferedWriter = new BufferedWriter(fileOutput);

        String baris1 = bufferedReader.readLine();
        bufferedWriter.write(baris1,0,baris1.length());
        bufferedWriter.flush();
        // menambah new line atau enter
        bufferedWriter.newLine();
        String baris2 = bufferedReader.readLine();
        bufferedWriter.write(baris2,0,baris2.length());
        bufferedWriter.flush();

        fileInput.close();
        bufferedReader.close();
        fileOutput.close();
        bufferedWriter.close();
    }
}
