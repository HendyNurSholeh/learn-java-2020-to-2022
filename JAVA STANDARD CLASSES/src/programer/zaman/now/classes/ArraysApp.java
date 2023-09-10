package programer.zaman.now.classes;

import java.util.Arrays;

public class ArraysApp {
    public static void main(String[] args) {

        int [] numbers = {
                1,4,939,4,5,2,8,9,7,6,56
        };

        Arrays.sort(numbers);

        System.out.println(Arrays.toString(numbers));

        System.out.println(Arrays.binarySearch(numbers,7));
        System.out.println(Arrays.binarySearch(numbers,3));

        int[] result = Arrays.copyOf(numbers,5);
        System.out.println(Arrays.toString(result));

        int[] result2 = Arrays.copyOfRange(numbers,5,10);
        System.out.println(Arrays.toString(result2));

    }
}
