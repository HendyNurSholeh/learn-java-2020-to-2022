package programmer.zaman.now.utility;

import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

public class UserInput {

    private static Scanner scanner = new Scanner(System.in);

    public static String input(String message){
        System.out.print(message + " : ");
        String inputUser = scanner.nextLine();
        return inputUser;
    }

    public static ResourceBundle getResourceBundle(){
        System.out.println("id = Indonesian");
        System.out.println("en = English");
        String inputLanguage = UserInput.input("Enter your language (id or en)");
        while(!(inputLanguage.equalsIgnoreCase("id")) && !(inputLanguage.equalsIgnoreCase("en"))){
            System.out.println("//YOUR INPUT IS NOT CORRECT, PLEASE ENTER CORRECTLY!");
            inputLanguage = UserInput.input("Enter your language");
        }
        ResourceBundle resourceBundle = ResourceBundle.getBundle("view", UserInput.locale(inputLanguage));
        return resourceBundle;
    }



    public static Locale locale(String inputUser){
        if (inputUser.equalsIgnoreCase("id")){
            Locale indonesia = new Locale("in", "ID");
            return indonesia;
        }else {
            Locale america = new Locale("en", "US");
            return america;
        }
    }
}
