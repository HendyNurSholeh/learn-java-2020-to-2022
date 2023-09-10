package programmer.zaman.now.classes;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class RegexApp {
    public static void main(String[] args) {
        String name = "Hendy Nur Sholeh";
        Pattern pattern = Pattern.compile("[a-zA-Z]*[n][a-zA-Z]*");
        Matcher ma = pattern.matcher(name);

        while (ma.find()){
            String value = ma.group();
            System.out.println(value);
        }

    }
}
