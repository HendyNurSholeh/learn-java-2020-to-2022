package programmer.zaman.now.lambda;

import java.util.ArrayList;
import java.util.List;

public class ForEachApp {
    public static void main(String[] args) {
        List<Integer> list = List.of(1,2,3,4,5);
        // Iterable.ForEach dengan menggunakan lambda
        System.out.println("---------Iterable.ForEach");
        list.forEach(System.out::println);
        // ForEach biasa
        System.out.println("---------ForEach biasa");
        for (var value : list) {
            System.out.println(value);
        }
    }
}
