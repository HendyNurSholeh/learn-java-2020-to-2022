package programmer.zaman.now.collection;

import java.util.*;

public class CollectionApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Collection<String> names = new ArrayList<>();
        System.out.print("Mauskkan jumlah data : ");
        Integer jumlahData = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < jumlahData; i++) {
            System.out.print("Masukkan data yang ingin ditambahkan : ");
            names.add(scanner.nextLine());
        }

        System.out.println("Data yang anda tambahkan adalah : ");
        for (var value : names) {
            System.out.println(value);
        }




        Collection<String> collection = new ArrayList<>();
        collection.add("hendy");
        collection.add("nur");
        collection.add("sholeh");

        collection.addAll(List.of("hendy"));

        System.out.println("\n\n\n\n");
        for (var value : collection) {
            System.out.println(value);
        }

        System.out.println("REMOVE");
        collection.remove("hendy");
        for (var value : collection) {
            System.out.println(value);
        }

        boolean cekName = collection.contains("Hendy");
        System.out.println(cekName);
        System.out.println(collection.containsAll(List.of("hendy", "nur")));

    }
}
