package programmerzamannow.datetime;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;

public class LocalDateTimeTest {

    @Test
    void testCreate() {
        LocalDate localDate = LocalDate.now();
        LocalTime localTime = LocalTime.parse("13:00");
        LocalDateTime localDateTime1 = LocalDateTime.now();
        LocalDateTime localDateTime2 = LocalDateTime.of(2004, Month.MAY, 16, 13, 30, 30);
        LocalDateTime localDateTime3 = LocalDateTime.parse("2004-05-16T13:30:30.544455765");
        LocalDateTime localDateTime4 = LocalDateTime.of(localDate, localTime);

        System.out.println(localDateTime1);
        System.out.println(localDateTime2);
        System.out.println(localDateTime3);
        System.out.println(localDateTime4);
    }

    @Test
    void withLocalDateTime() {
        LocalDateTime localDateTime = LocalDateTime.of(2004, Month.MAY, 16, 13, 30, 30);
        LocalDateTime dateTime = localDateTime.withYear(2000).withMonth(2).withDayOfMonth(2)
                .withHour(2).withMinute(2).withSecond(2).withNano(2);
        System.out.println(dateTime);
    }

    @Test
    void modifyLocalDateTime() {
        var now = LocalDateTime.now();
        LocalDateTime plusYears = now.plusYears(1);
        LocalDateTime minusYears = now.minusYears(1);
        System.out.println(plusYears);
        System.out.println(minusYears);
    }

    @Test
    void getLocalDateTime() {
        var now = LocalDateTime.now();
        System.out.println(now.getHour());
        System.out.println(now.getYear());
    }
}
