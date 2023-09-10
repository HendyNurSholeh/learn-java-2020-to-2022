package com.tutorial;


class Display{
    static String type = "Display";
    private String name;

    Display(String name){
        this.name =name ;
    }

    void setType(String typeInput){
       // type = typeInput;  // alternatif 1
       // this.type = typeInput; // alternatif 2
       Display.type = typeInput; // alternatif 3
    }

    void show(){
        System.out.println("Display name = "+ this.name);
    }
}


public class Main {
    
    public static void main(String[] args) {

        Display display1 = new Display("monitor");
        display1.show();

        Display display2 = new Display("Smartphone");
        display2.show();

        // tampilkan static variabel atau class variable

        // kita coba mengganti variable staticnya
        display1.setType("tampilan");

        System.out.println("\nMenampilkan static atau class variable");
        System.out.println(display1.type);
        System.out.println(display2.type);
        System.out.println(Display.type);


    }

}
