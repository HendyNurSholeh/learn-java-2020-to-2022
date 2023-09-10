package hyns.latihan;

import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Input Sebuah angka: ");
        int input = scanner.nextInt();
        System.out.println("============================");
        int index = 1;
        while (index <= 10){
            int hasil = input/index;
            int sisaBagi = input%index;
            System.out.println(input + ":" + index + " = " + hasil + " sisa " + sisaBagi);
            index++;
        }
    }
}
