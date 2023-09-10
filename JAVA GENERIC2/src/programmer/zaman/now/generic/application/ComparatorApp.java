package programmer.zaman.now.generic.application;

import programmer.zaman.now.generic.People;

import java.util.Arrays;
import java.util.Comparator;

public class ComparatorApp {
    public static void main(String[] args) {
        People people[] = {
                new People("usop","kalimantan"),
                new People("sanji","jawa"),
                new People("zzzz","jakarta")
        };

        Comparator<People> comparator = new Comparator<People>() {
            @Override
            public int compare(People o1, People o2) {
                return o1.getData().compareTo(o2.getData());
            }
        };

        Arrays.sort(people, comparator);

        System.out.println(Arrays.toString(people));
    }
}
