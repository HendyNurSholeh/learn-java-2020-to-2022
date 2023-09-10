package programer.zaman.now.classes;

import java.util.Calendar;
import java.util.Date;

public class DateApp {
    public static void main(String[] args) {
        Date tanggal = new Date();
        // tidak direkomendasikan

        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR,2000);
        calendar.set(Calendar.MONTH,0);
        calendar.set(Calendar.HOUR_OF_DAY,10);

        Date result = calendar.getTime();
        System.out.println(result);
    }
}
