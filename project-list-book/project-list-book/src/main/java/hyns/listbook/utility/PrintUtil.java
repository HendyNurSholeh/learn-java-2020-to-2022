package hyns.listbook.utility;

import hyns.listbook.entity.Books;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public class PrintUtil {

    public static void showBooks(List<Books> booksList){
        var no = new AtomicInteger();
        log.info("+----------------------------------------------------------------------------------+");
        log.info(String.format("| %-4s| %-6s| %-25s| %-20s| %-18s|"
                , "NO", "TAHUN", "JUDUL", "PENULIS", "PENERBIT"));
        log.info("+----------------------------------------------------------------------------------+");
        booksList.forEach(value -> {
            log.info(String.format("| %-4d| %-6d| %-25s| %-20s| %-18s|"
                    , no.incrementAndGet(), value.getTahun(), value.getJudul()
                    , value.getPenulis(), value.getPenerbit()));
        });
        log.info("+----------------------------------------------------------------------------------+");
    }
}
