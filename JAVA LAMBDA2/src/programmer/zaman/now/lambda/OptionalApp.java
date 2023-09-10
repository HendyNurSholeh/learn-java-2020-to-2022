package programmer.zaman.now.lambda;

import java.util.Locale;
import java.util.Optional;

public class OptionalApp {
    public static void main(String[] args) {
        sayHello("hendy");
    }

    public static void sayHello(String name){
//        if (name != null){
//            String upperName = name.toUpperCase();
//            System.out.println("HELLO " + upperName);
//        }
//        Optional<String> optional = Optional.ofNullable(name);
//        Optional<String> optional1 = optional.map(String::toUpperCase);
//        optional1.ifPresent(value -> System.out.println("HELLO " + optional1.get()));
         String upperName = Optional.ofNullable(name)
                .map(String::toUpperCase)
                .orElse("KAWAN");
         System.out.println("HELLO " + upperName);
    }
}
