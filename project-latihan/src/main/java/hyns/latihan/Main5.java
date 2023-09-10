package hyns.latihan;

import java.util.Scanner;

public class Main5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] array = new int[5];

        System.out.print("Input bilangan ke-1 : ");
        array[0] = scanner.nextInt();
        System.out.print("Input bilangan ke-2 : ");
        array[1] = scanner.nextInt();
        System.out.print("Input bilangan ke-3 : ");
        array[2] = scanner.nextInt();
        System.out.print("Input bilangan ke-4 : ");
        array[3] = scanner.nextInt();
        System.out.print("Input bilangan ke-5 : ");
        array[4] = scanner.nextInt();
        System.out.println("============================");
        System.out.print("Data yang diinputkan adalah : ");
        System.out.println(array[0] + " " + array[1] + " " + array[2] + " " + array[3] + " " + array[4]);
    }
}
