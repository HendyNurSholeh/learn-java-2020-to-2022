package programmerzamannow.datetime;

import org.junit.jupiter.api.Test;

import java.time.*;

public class OffsetTest {

    @Test
    void createOffsetTime() {
        OffsetTime offsetTime = OffsetTime.now();
        OffsetTime offsetTime1 = OffsetTime.now(ZoneId.of("Asia/Jakarta"));
        OffsetTime offsetTime2 = OffsetTime.of(LocalTime.now(), ZoneOffset.of("+01:00"));
        System.out.println(offsetTime);
        System.out.println(offsetTime1);
        System.out.println(offsetTime2);
    }

    @Test
    void create() {
        OffsetDateTime offsetDateTime = OffsetDateTime.now();
        OffsetDateTime offsetDateTime1 = OffsetDateTime.now(ZoneId.of("Asia/Jakarta"));
        OffsetDateTime offsetDateTime2 = OffsetDateTime.of(LocalDateTime.now(), ZoneOffset.of("+01:00"));
        System.out.println(offsetDateTime);
        System.out.println(offsetDateTime1);
        System.out.println(offsetDateTime2);
    }

    @Test
    void localTime() {
        LocalTime localTime = LocalTime.now();
        System.out.println(localTime);
        OffsetTime offsetTime = localTime.atOffset(ZoneOffset.of("+01:00"));
        System.out.println(offsetTime);
        LocalTime localTime1 = offsetTime.toLocalTime();
        System.out.println(localTime1);

        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime);
        OffsetDateTime offsetDateTime = localDateTime.atOffset(ZoneOffset.of("+01:00"));
        System.out.println(offsetDateTime);
        LocalDateTime localDateTime1 = offsetDateTime.toLocalDateTime();
        System.out.println(localDateTime1);
    }
}
