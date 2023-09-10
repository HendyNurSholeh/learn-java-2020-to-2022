package programer.zaman.now.classes;

import java.math.BigInteger;

public class BigNumbarApp {
    public static void main(String[] args) {
        BigInteger a = new BigInteger("10000000000000000000");
        BigInteger b = new BigInteger("10000000000000000000");

        BigInteger c = a.add(b);
        System.out.println(c);
    }
}
