package programmerzamannow.datetime;

import org.junit.jupiter.api.Test;

import java.time.*;

public class InstantTest {

    @Test
    void create() {
        Instant instant = Instant.now();
        Instant instant1 = Instant.ofEpochMilli(System.currentTimeMillis());
        Instant instant2 = Instant.ofEpochMilli(0);
        System.out.println(instant);
        System.out.println(instant1);
        System.out.println(instant2);
    }

    @Test
    void modify() {
        Instant instant = Instant.now();
        Instant instant1 = instant.plusSeconds(600);
        System.out.println(instant);
        System.out.println(instant1);
    }

    @Test
    void get() {
        Instant instant = Instant.now();
        System.out.println(instant.toEpochMilli());
        System.out.println(instant.getEpochSecond());
        System.out.println(instant.getEpochSecond());
    }

    @Test
    void convert() {
        Instant instant = Instant.now();

        LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, ZoneOffset.ofHours(8));
        LocalDate localDate = LocalDate.ofInstant(instant, ZoneId.of("Asia/Makassar"));
        LocalTime localTime = LocalTime.ofInstant(instant, ZoneId.of("Asia/Makassar"));

        System.out.println(localDateTime);
        System.out.println(localDate);
        System.out.println(localTime);
    }

    @Test
    void convertToInstant() {
        Instant instant = LocalDate.now().atTime(15, 30).atZone(ZoneId.of("Asia/Makassar")).toInstant();
        Instant instant1 = LocalDateTime.now().toInstant(ZoneOffset.ofHours(8));
        System.out.println(instant);
        System.out.println(instant1.toEpochMilli());
    }
}
