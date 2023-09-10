package programmerzamannow.datetime;

import org.junit.jupiter.api.Test;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class TimeZoneTest {

    @Test
    void testTimeZone() {
        Calendar calendar = Calendar.getInstance();
        Integer jam = calendar.get(Calendar.HOUR_OF_DAY);
        Integer menit = calendar.get(Calendar.MINUTE);
        Integer second = calendar.get(Calendar.SECOND);
        System.out.printf("%d:%d:%d", jam, menit, second);
        calendar.setTimeZone(TimeZone.getTimeZone("Asia/Jakarta"));
        Integer jam2 = calendar.get(Calendar.HOUR_OF_DAY);
        Integer menit2 = calendar.get(Calendar.MINUTE);
        Integer second2 = calendar.get(Calendar.SECOND);
        System.out.printf("\n%d:%d:%d", jam2, menit2, second2);
    }

    @Test
    void testDate() {
        var date = new Date();
        System.out.println(date);
        System.out.println(date.toString());
    }

    @Test
    void date() {
        var now = LocalDateTime.now();
        LocalDate localDate = now.toLocalDate();
        System.out.println(localDate);
        LocalDateTime localDateTime = localDate.atTime(13, 0);
        System.out.println(localDateTime);
    }

    @Test
    void time() {
        var nowLocalDateTime = LocalDateTime.now();
        LocalTime localTime = nowLocalDateTime.toLocalTime();
        System.out.println("convert LocalDateTime to Local time = " + localTime);

        var nowTime = LocalTime.now();
        LocalDateTime localDateTime = nowTime.atDate(LocalDate.of(2004, 05, 16));
        System.out.println("convert Local time to LocalDateTime = " + localDateTime);
    }
}
