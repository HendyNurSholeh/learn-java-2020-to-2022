package com.tutorial;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Contoh {
    public static void main(String[] args)throws IOException{
        FileInputStream inputFile = null;
        try {
        inputFile = new FileInputStream("input.txt");
            System.out.println((char) inputFile.read());
        }finally {
            if (inputFile!=null) {
                inputFile.close();
            }
        }


        System.out.println("akhir dari program");
    }

}
