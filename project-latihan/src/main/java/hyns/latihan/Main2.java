package hyns.latihan;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Input Sebuah angka : ");
        int input = scanner.nextInt();
        System.out.println("============================");
        int index = 1;
        System.out.println("Angka yang dapat membagi 30 tanpa sisa adalah:");
        do {
            if (input % index == 0){
                int hasil = index;
                System.out.print(hasil + ", ");
            }
            index++;
        }while (index<=input);
    }
}
