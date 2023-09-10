package programmer.zaman.now.classes;
import java.util.Calendar;
import java.util.Date;

public class DateApp {
    public static void main(String[] args) {
        Date tanggal = new Date();
        System.out.println(tanggal);

        Calendar calandar = Calendar.getInstance();
        calandar.set(Calendar.YEAR, 2004);
        Date date = calandar.getTime();
        System.out.println(date);

    }
}
