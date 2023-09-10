package programmer.zaman.now.generic.application;

import programmer.zaman.now.generic.People;

import java.util.Arrays;

public class CompareToApp {
    public static void main(String[] args) {
        String data[] = {"Eko", "Budi", "Joko"};
        Arrays.sort(data);
        System.out.println(Arrays.toString(data));

        People people[] = {
                new People("usop","kalimantan"),
                new People("sanji","jawa"),
                new People("zzzz","jakarta")
        };

        Arrays.sort(people);

        System.out.println(Arrays.toString(people));

    }

}
