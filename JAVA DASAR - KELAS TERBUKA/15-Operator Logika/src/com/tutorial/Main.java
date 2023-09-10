package com.tutorial;

public class Main {

    public static void main(String[] args){

        // Operator logika --> operasi yang bisa kita lakukan kepada tipe data boolean
        // AND, OR, XOR, negasi

        boolean a,b,c;

        // OR / atau (||)
        System.out.println();
        System.out.println("----OR (||)----");
        a = false;
        b = false;
        c = (a||b);
        System.out.println(a + " || " + b +" = "+c);
        a = false;
        b = true;
        c = (a||b);
        System.out.println(a + " || " + b +" = "+c);
        a = true;
        b = false;
        c = (a||b);
        System.out.println(a + " || " + b +" = "+ c);
        a = true;
        b = true;
        c = (a||b);
        System.out.println(a + " || " + b +" = "+ c);

        // AND / dan (&&)
        System.out.println();
        System.out.println("----AND (&&)----");
        a = false;
        b = false;
        c = (a&&b);
        System.out.println(a + " || " + b +" = "+c);
        a = false;
        b = true;
        c = (a&&b);
        System.out.println(a + " || " + b +" = "+c);
        a = true;
        b = false;
        c = (a&&b);
        System.out.println(a + " || " + b +" = "+ c);
        a = true;
        b = true;
        c = (a&&b);
        System.out.println(a + " || " + b +" = "+ c);

        // XOR / exlusive or (^)
        System.out.println();
        System.out.println("----XOR (^)----");
        a = false;
        b = false;
        c = (a^b);
        System.out.println(a + " || " + b +" = "+c);
        a = false;
        b = true;
        c = (a^b);
        System.out.println(a + " || " + b +" = "+c);
        a = true;
        b = false;
        c = (a^b);
        System.out.println(a + " || " + b +" = "+ c);
        a = true;
        b = true;
        c = (a^b);
        System.out.println(a + " || " + b +" = "+ c);

        // NOR / negasi-> flipping (!)
        System.out.println();
        System.out.println("----NEGASI (!)----");
        a = true;
        b = !a;
        System.out.println("--> (!) = "+ b);

        a = false;
        b = !a;
        System.out.println("--> (!) = "+ b);

    }
}
