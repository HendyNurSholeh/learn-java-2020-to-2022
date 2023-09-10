package programmer.zaman.now.collection;

import java.util.*;

public class QueueApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> list = new ArrayList<>();

        System.out.print("Masukkan jumlah list yang ingin dimasukkan : ");
        String inputJumlah = scanner.nextLine();
        Integer jumlahList = Integer.valueOf(inputJumlah);

        for (int i = 0; i < jumlahList; i++) {
            System.out.print("Masukkan list : ");
            String inputList = scanner.nextLine();
            list.add(inputList);
        }

        System.out.println("TAMPILAN");
        int template = 1;
        for (int i = 0; i < jumlahList; i++){
            System.out.printf("%d. %s\n",(i+1),list.get(jumlahList-template));
            template += 1;
        }


//        Queue<Integer> numbers = new ArrayDeque<>(10);
//        numbers.add(4);
//        numbers.add(4);
//        numbers.add(4);
//        numbers.add(4);
//        numbers.add(4);
//        numbers.add(4);
//        numbers.add(4);
//        numbers.add(4);
//        numbers.add(4);
//        numbers.add(4);

//        for (var value : numbers2){
//            System.out.println(value);
//        }
//        System.out.println(numbers.size());
//        System.out.println(numbers.element());

//        System.out.println(numbers.size());

    }
}
