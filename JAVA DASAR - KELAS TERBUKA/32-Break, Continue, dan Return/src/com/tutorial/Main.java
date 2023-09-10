package com.tutorial;

public class Main {

    public static void main(String[] args) {
	// Break, Continue, dan Return
        int a = 0;

        while (true){
            a++;
            if (a==10){
                break;
                //keluar dari while
            }else if (a==7) {
                continue;
                //memulai ulang loop
            }else if (a==5)
                return;
            //
            System.out.println("looping ke = "+a);
        }


    }
}
