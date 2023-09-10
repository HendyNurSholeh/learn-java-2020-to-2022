package programmer.zaman.now.collection;

import java.util.ArrayList;
import java.util.List;
import java.util.Spliterator;
import java.util.function.IntFunction;

public class SpliteratorApp {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(3);
        list.add(2);
        list.add(5);
        list.add(4);
        list.add(6);
        list.add(6);
        list.add(6);

        Object[] objects = list.toArray();
        Integer[] strings = list.toArray(new Integer[]{});

        System.out.println("String");
        for (var value : strings) {
            System.out.println(value);
        }

        System.out.println("Object");
        for (var value : objects) {
            System.out.println(value);
        }

    }
}
