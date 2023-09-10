package programmer.zaman.now.collection;

import java.util.ArrayList;
import java.util.List;
import java.util.function.UnaryOperator;

public class CollectionDefaultMethodApp {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= 100; i++) {
            list.add(i);
        }

        list.forEach(System.out::println);
        System.out.println("---------------------------");
        list.removeIf(value -> value % 2 == 0);
        list.forEach(System.out::println);


        }
}
