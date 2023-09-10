package programmer.zaman.now.application;
// dengan menggunakan kata kunci * kita menginport semua
// class yang ada di package tersebut
import programmer.zaman.now.data.*;

public class Aplication {
    public static void main(String[] args) {
        Product product = new Product("Mac Book Pro",30000000);
        System.out.println(product.name);
        System.out.println(product.price);
    }
}
