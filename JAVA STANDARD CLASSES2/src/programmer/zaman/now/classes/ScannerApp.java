package programmer.zaman.now.classes;

import java.util.Scanner;

public class ScannerApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nama : ");
        String nama = sc.nextLine();
        System.out.println("Hello " + nama);
    }
}
