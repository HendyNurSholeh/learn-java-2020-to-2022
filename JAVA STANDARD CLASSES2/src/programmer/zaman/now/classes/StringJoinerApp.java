package programmer.zaman.now.classes;

import java.util.Scanner;
import java.util.StringJoiner;

public class StringJoinerApp {
    public static void main(String[] args) {
        String[] array = {"hendy", "nur", "sholeh"};
        StringJoiner joiner = new StringJoiner(" ");
        for (var value:array) {
            joiner.add(value);
        }
        System.out.println(joiner);
        StringJoiner names = joiner.add(joiner());
        System.out.println(names.toString());
    }
    static String joiner(){
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();
        return name;
    }
}
