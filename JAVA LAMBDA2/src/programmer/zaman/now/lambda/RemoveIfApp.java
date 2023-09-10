package programmer.zaman.now.lambda;

import java.util.ArrayList;
import java.util.List;

public class RemoveIfApp {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        numbers.addAll(List.of(1,2,3,4,5,6));
        numbers.removeIf(value -> value > 3);
        System.out.println(numbers);
    }
}
