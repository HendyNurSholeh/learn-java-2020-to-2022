package programer.zaman.now.classes;

import java.util.Arrays;
import java.util.Locale;

public class StringApp {
    public static void main(String[] args) {
        // sebenernya pada saat upper dan lower itu membuat string baru
        String name = "Eko Kurniawan Khannedy";
        String nameLowerCase = name.toLowerCase(Locale.ROOT);
        String nameUpperCase = name.toUpperCase(Locale.ROOT);

        System.out.println(name);
        System.out.println(nameLowerCase);
        System.out.println(nameUpperCase);
        System.out.println(name.length());
        System.out.println(name.startsWith("Eko"));
        System.out.println(name.endsWith("Khannedy"));

        String[] names = name.split(" ");
        for (var value: names){
            System.out.println(value);
        }

        System.out.println(" ".isBlank());
        System.out.println(" ".isEmpty());
        System.out.println("".isEmpty());
        System.out.println(name.charAt(0));

        char[] chars = name.toCharArray();
        System.out.println(Arrays.toString(chars));
    }
}
