package programmer.zaman.now.collection;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class DequeApp {
    public static void main(String[] args) {
        Deque<String> deque = new ArrayDeque<>();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Masukkan berapa banyak yg diinput : ");
        Integer input = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < input; i++) {
            System.out.print("Input " + (i+1) + " : ");
            deque.offerFirst(scanner.nextLine());
        }

        System.out.println("TAMPILAN : ");
        for(var value : deque){
            System.out.println(value);
        }

    }
}
