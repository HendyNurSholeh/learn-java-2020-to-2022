package com.tutorial;

public class Lain {

    // bagian ini dapat diakses oleh siapapun
    public static void methodPublic() {
        System.out.println("Lain:public");
    }

    // ini hanya dapat diakses oles class yang bersangkutan
    private static void methodprivate() {
        System.out.println("Lain:private");
    }

    // ini hanya dapat diakses oleh class dalam package yang sama
    static void methodDefault() {
        System.out.println("Lain:default");
    }

    // ini hanya dapat diakses oleh class dalam package yang sama
    // dan subkelasnya
    protected static void methodProtected() {
        System.out.println("Lain:protected");
    }
}