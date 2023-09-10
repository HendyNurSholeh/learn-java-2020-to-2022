package com.tutorial;

public class Main {

    public static void main(String[] args) {
	// y = (x + 2) * x
        int y,x;
        x = 5;
        y = hitung(x);
        System.out.println("x = "+x+", y = "+y);

        x = 10;
        y = hitung(x);
        System.out.println("x = "+x+", y = "+y);

        x = 20;
        y = hitung(x);
        System.out.println("x = "+x+", y = "+y);
    }
    static int hitung(int input){
        int hasil;
        hasil = (input+2) * input;
        return hasil;
    }
}
