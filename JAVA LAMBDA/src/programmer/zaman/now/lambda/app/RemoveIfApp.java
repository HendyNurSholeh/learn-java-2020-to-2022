package programmer.zaman.now.lambda.app;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class RemoveIfApp {
    public static void main(String[] args) {

        List<String> names = new ArrayList<>();

        names.addAll(List.of("Eko","Kurniawan","Khannedy"));

        // remove if anonymous class
//        names.removeIf(new Predicate<String>() {
//            @Override
//            public boolean test(String names) {
//                return names.length() > 5;
//            }
//        });

        // lambda
        names.removeIf(name -> name.length() > 5);

        names.forEach(System.out::println);
    }
}
