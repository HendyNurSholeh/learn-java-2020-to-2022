package programmer.zaman.now.utility;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.util.Locale;
import java.util.ResourceBundle;

public class ResouceBundleUtil {

    public static ResourceBundle resourceBundle;

    static {
        System.out.println("id = Indonesian");
        System.out.println("en = English");
        // Mengambil input user
        String inputLanguage = UserInput.input("Enter your language (id or en)");
        // Jika input user tidak sesuai format
        while(!(inputLanguage.equalsIgnoreCase("id")) && !(inputLanguage.equalsIgnoreCase("en"))){
            System.out.println("//YOUR INPUT IS NOT CORRECT, PLEASE ENTER CORRECTLY!");
            inputLanguage = UserInput.input("Enter your language");
        }

        Locale locale = new Locale("en", "US");
        if (inputLanguage.equalsIgnoreCase("id")){
            locale = new Locale("in", "ID");
        }
        resourceBundle = ResourceBundle.getBundle("view", locale);
    }

    public static ResourceBundle getResourceBundle(){
        return resourceBundle;
    }
}
