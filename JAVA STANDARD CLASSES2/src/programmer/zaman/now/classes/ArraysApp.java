package programmer.zaman.now.classes;

import java.util.Arrays;

public class ArraysApp {
    public static void main(String[] args) {
        String[] name = {"baca", "aku", "catat"};
        Arrays.sort(name);
        System.out.println(Arrays.toString(name));
        String[] nameCopy = Arrays.copyOf(name, name.length);
        System.out.println(Arrays.toString(nameCopy));
        int index = Arrays.binarySearch(nameCopy, "catat");
        System.out.println(index);
    }
}
