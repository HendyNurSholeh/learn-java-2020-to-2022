package com.tutorial;

public class Main {

    public static void main(String[] args) {
	// void itu artinya hampa

        // hanya mengembalikan rumus
        denganVoid("apapun");
        // mengembalikan nilai
        System.out.println(tanpaVoid());

    }
    // fungsi atau method tanpa pengembalian
    private static void denganVoid(String input){
        System.out.println(input);
    }
    // fungsi atau method dengan kembalian
    // sehingga menggunakan return untuk
    // mengembalikan nilai (10.0f)
    private static float tanpaVoid(){
        return 10.0f;
    }
}
