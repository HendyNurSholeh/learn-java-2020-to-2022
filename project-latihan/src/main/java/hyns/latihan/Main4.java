package hyns.latihan;

import java.util.Scanner;

public class Main4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input jumlah baris : ");
        int jumlahBaris = scanner.nextInt();
        System.out.print("Input jumlah kolom : ");
        int jumlahKolom = scanner.nextInt();
        System.out.println("============================");
        int index = 1;
        for (int i = 0; i < jumlahBaris; i++){
            for (int j = 0; j < jumlahKolom; j++){
                if (index % 2 == 0){
                    System.out.print("O ");
                } else {
                     System.out.print("X ");
                }
                index++;
            }
            System.out.println();
        }
    }
}
