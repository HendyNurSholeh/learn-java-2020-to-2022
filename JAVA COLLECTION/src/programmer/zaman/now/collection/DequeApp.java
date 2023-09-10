package programmer.zaman.now.collection;

import java.util.Deque;
import java.util.LinkedList;

public class DequeApp {
    public static void main(String[] args) {

        Deque<String> deque = new LinkedList<>();

        deque.offerLast("Eko");
        deque.offerLast("Kurniawan");
        deque.offerLast("Khannedy");

        System.out.println(deque.pollLast());
        System.out.println(deque.pollLast());
        System.out.println(deque.pollLast());

        Deque<String> queue = new LinkedList<>();
        queue.offerLast("Eko");
        queue.offerLast("Kurniawan");
        queue.offerLast("Khannedy");

        System.out.println(queue.pollFirst());
        System.out.println(queue.pollFirst());
        System.out.println(queue.pollFirst());
    }
}
