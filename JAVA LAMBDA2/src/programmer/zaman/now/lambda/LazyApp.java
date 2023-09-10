package programmer.zaman.now.lambda;

import programmer.zaman.now.lambda.data.GetData;

import java.util.function.Supplier;

public class LazyApp {
    public static void main(String[] args) {
        cekNilai(80, new GetData() );

    }

    public static void cekNilai(int nilai, GetData name){
        if (nilai < 60){
            System.out.println("Maaf " + name.getName() + ", nilai anda belum mencukupi");
        }else {
            System.out.println("Selamat anda lulus");
        }
    }
//    public static String getName(){
//        System.out.println("Method ini dipanggil");
//        return "hendy";
//    }
}
