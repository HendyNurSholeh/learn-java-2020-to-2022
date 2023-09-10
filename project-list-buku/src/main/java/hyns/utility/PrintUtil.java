package hyns.utility;

import hyns.entity.Books;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class PrintUtil {

    public static void showBooks(List<Books> booksList){
        var no = new AtomicInteger();
        System.out.println("+----------------------------------------------------------------------------------+");
        System.out.printf("| %-4s| %-6s| %-25s| %-20s| %-18s|\n"
                , "No", "Tahun", "Judul", "Penulis", "penerbit");
        System.out.println("+----------------------------------------------------------------------------------+");
        booksList.forEach(value -> {
            System.out.printf("| %-4d| %-6d| %-25s| %-20s| %-18s|\n"
                    , no.incrementAndGet(), value.getTahun(), value.getJudul()
                    , value.getPenulis(), value.getPenerbit());
        });
        System.out.println("+----------------------------------------------------------------------------------+");
    }
}
