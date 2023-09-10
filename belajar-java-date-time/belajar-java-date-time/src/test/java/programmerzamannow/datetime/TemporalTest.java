package programmerzamannow.datetime;

import org.junit.jupiter.api.Test;

import java.time.*;
import java.time.temporal.ChronoField;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.List;

public class TemporalTest {

    @Test
    void create() {
        Temporal temporal1 = LocalDate.now();
        Temporal temporal2 =LocalTime.now();
        Temporal temporal3 =LocalDateTime.now();
        Temporal temporal4 =ZonedDateTime.now();

        System.out.println(temporal1);
        System.out.println(temporal2);
        System.out.println(temporal3);
        System.out.println(temporal4);
    }

    @Test
    void TemporalAmount() {
        Clock clock = Clock.systemDefaultZone();
        ZonedDateTime zonedDateTime = ZonedDateTime.now(clock);
        System.out.println(zonedDateTime);
        System.out.println(zonedDateTime.plus(Period.ofDays(1)));
    }

    @Test
    void testTemporalField() {
        Temporal temporal = LocalTime.now();
        System.out.println(temporal);
        System.out.println(temporal.get(ChronoField.HOUR_OF_DAY));
    }

    @Test
    void testTemporalQuery() {
        LocalDateTime localDateTime = LocalDateTime.now();
        List<Integer> query = localDateTime.query(value -> {
            List<Integer> list = new ArrayList<>();
            list.add(value.get(ChronoField.HOUR_OF_DAY));
            list.add(value.get(ChronoField.MINUTE_OF_HOUR));
            list.add(value.get(ChronoField.SECOND_OF_MINUTE));
            return list;
        });

        System.out.println(query);
    }

    @Test
    void testTemporalAdjuster() {
        LocalDateTime localTime = LocalDateTime.now();
        LocalDateTime localTime1 = localTime.with(TemporalAdjusters.lastDayOfMonth());
        System.out.println(localTime1);
    }
}
