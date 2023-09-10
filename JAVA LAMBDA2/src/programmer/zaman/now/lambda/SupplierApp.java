package programmer.zaman.now.lambda;

import java.util.List;
import java.util.function.Supplier;

public class SupplierApp {
    public static void main(String[] args) {
        Supplier<List<Integer>> numbers = () -> List.of(1,2,3,4,5);
        System.out.println(numbers.get());
    }
}
