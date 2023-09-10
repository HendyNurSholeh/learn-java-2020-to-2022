package programmer.zaman.now.classes;

import java.util.Base64;

public class Base64App {
    public static void main(String[] args) {
        String name = "Hendy Nur Sholeh";
        String encoded = Base64.getEncoder().encodeToString(name.getBytes());
        System.out.println(encoded);

        byte[] byt = Base64.getDecoder().decode(encoded);
        String stringName = new String(byt);
        System.out.println(stringName);



    }
}
