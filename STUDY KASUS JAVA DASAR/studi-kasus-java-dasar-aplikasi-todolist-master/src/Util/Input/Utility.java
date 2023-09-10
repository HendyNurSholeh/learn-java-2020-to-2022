package Util.Input;

import java.util.Scanner;

public class Utility {

    public static String input(String info){
        Scanner sc = new Scanner(System.in);
        System.out.print(info + " : ");
        String input = sc.nextLine();
        return input;
    }

}
