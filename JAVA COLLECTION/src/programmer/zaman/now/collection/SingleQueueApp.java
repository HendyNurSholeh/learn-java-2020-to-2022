package programmer.zaman.now.collection;

import programmer.zaman.now.collection.collection.SinggleQueue;

import java.util.Queue;

public class SingleQueueApp {
    public static void main(String[] args) {

        Queue<String> queue = new SinggleQueue<>();
        System.out.println(queue.size());

        System.out.println(queue.offer("Eko"));
        System.out.println(queue.offer("Kurniawan"));
        System.out.println(queue.offer("Khannedy"));

        System.out.println(queue.size());

        System.out.println(queue.peek());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.size());
    }
}
