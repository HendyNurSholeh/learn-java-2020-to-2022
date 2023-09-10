package programmer.zaman.now.lambda;

import java.util.function.Function;
import java.util.function.Predicate;

public class PredicateApp {
    public static void main(String[] args) {
        Predicate<Integer> isGanjil = value -> {
            if (value == null || value <= 0) {
                return false;
            } else {
                return value % 2 == 0;
            }
        };
        System.out.println(isGanjil.test(-4));

        Function<Integer, Boolean> function = value -> value % 2 == 0;
        boolean isGenap = function.apply(3);
        System.out.println(isGenap);


    }
}
