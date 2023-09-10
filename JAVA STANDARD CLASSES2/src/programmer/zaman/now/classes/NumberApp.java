package programmer.zaman.now.classes;
import java.util.Scanner;

public class NumberApp{
    public static void main(String[] args)  {
        String angka = "10000";
        Double angkaDouble = Double.valueOf(10000);
        Integer angkaInteger = Integer.valueOf(angka);
        System.out.println(angkaDouble);
        System.out.println(angkaInteger);

        int a = 20;
        double b = (double) a;
        System.out.println(b);

        boolean bol = true;
        while (bol){
        Scanner sc = new Scanner(System.in);
        System.out.print("Masukkan angka : ");
        String angkaStr = sc.nextLine();
        try {
            int angkaInt2 = Integer.parseInt(angkaStr);
            System.out.println("angka yang anda masukkan adalah " + angkaInt2);
            bol = false;
        }catch (NumberFormatException e){
            System.out.println("angka angka tidak dimengerti silahkan masukkan angka lagi");
        }
        }


    }
}
