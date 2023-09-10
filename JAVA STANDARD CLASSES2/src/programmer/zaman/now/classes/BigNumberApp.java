package programmer.zaman.now.classes;

import java.math.BigInteger;
import java.util.Scanner;

public class BigNumberApp {
    public static void main(String[] args) {
        BigInteger angka1 = new BigInteger("10");
        BigInteger angka2 = new BigInteger("20");
        System.out.println(angka1.add(angka2));
        Scanner sc = new Scanner(System.in);
        Integer inputUser = sc.nextInt();
        FizzBuzz(inputUser);
    }
    static void FizzBuzz(Integer angka){
        for (int i = 1; i <= angka; i++) {
            if (i%3==0 && i%5==0) {
                System.out.println("FizzBuzz");
            }else if (i%3==0){
                System.out.println("Fizz");
            }else if(i%5==0){
                System.out.println("Buzz");
            }else {
                System.out.println(i);
            }
        }
    }
}
