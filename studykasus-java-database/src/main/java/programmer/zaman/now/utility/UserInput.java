package programmer.zaman.now.utility;

import java.util.Scanner;

public class UserInput {

    private static Scanner scanner = new Scanner(System.in);

    public static String input(String message){
        System.out.print(message + " : ");
        String inputUser = scanner.nextLine();
        return inputUser;
    }
}
