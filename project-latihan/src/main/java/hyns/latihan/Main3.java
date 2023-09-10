package hyns.latihan;

import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        int bilanganGanjil = 0;
        int bilanganGenap = 0;
        Scanner scanner = new Scanner(System.in);

        System.out.print("Input Sebuah angka : ");
        int input = scanner.nextInt();
        System.out.println("============================");
        System.out.println("Angka yang merupakan kelipatan 3 atau 5 kurang dari " + input + " adalah:");
        for (int i = 1; i < input; i++){
            if (i % 3 == 0 || i % 5 == 0){
                int hasil = i;
                System.out.print(hasil + " ");
                if (hasil % 2 == 0){
                    bilanganGenap = bilanganGenap + 1;
                }else {
                    bilanganGanjil = bilanganGanjil + 1;
                }
            }
        }
        System.out.println();
        System.out.println("Jumlah angka genap  : " + bilanganGenap + " angka");
        System.out.println("Jumlah angka ganjil : " + bilanganGanjil + " angka");
    }
}
