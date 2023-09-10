package programmer.zaman.now.lambda;

import java.util.function.Function;

public class FunctionApp {
    public static void main(String[] args) {
        Object[] objects = {1, "hendy", 2.5, 50, 'a'};
        Function<Object[], Integer> function = o -> o.length;
        System.out.println(function.apply(objects));
    }

}
