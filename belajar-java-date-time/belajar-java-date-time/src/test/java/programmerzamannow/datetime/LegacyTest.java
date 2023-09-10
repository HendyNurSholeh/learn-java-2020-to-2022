package programmerzamannow.datetime;

import org.junit.jupiter.api.Test;

import java.time.*;
import java.util.Date;

public class LegacyTest {

    @Test
    void fromDate() {
        Date date = new Date();
        Instant instant = date.toInstant();
        LocalTime localDate = LocalTime.ofInstant(instant, ZoneOffset.ofHours(8));
        System.out.println(localDate);
    }

    @Test
    void fromLocalTime() {
        LocalTime localTime = LocalTime.now();
        LocalDateTime localDateTime = localTime.atDate(LocalDate.now());
        Instant instant = localDateTime.toInstant(ZoneOffset.ofHours(8));

        Date date = Date.from(instant);
        System.out.println(date);
    }
}
