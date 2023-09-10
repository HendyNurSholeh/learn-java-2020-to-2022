package programmerzamannow.datetime;

import org.junit.jupiter.api.Test;

import java.time.*;

public class ZoneDateTimeTest {

    @Test
    void create() {
        ZonedDateTime zonedDateTime1 = ZonedDateTime.now();
        ZonedDateTime zonedDateTime2 = ZonedDateTime.now(ZoneId.of("Asia/Jakarta"));
        ZonedDateTime zonedDateTime3 = ZonedDateTime.of(LocalDateTime.now(), ZoneId.of("Asia/Jakarta"));

        System.out.println(zonedDateTime1);
        System.out.println(zonedDateTime2);
        System.out.println(zonedDateTime3);
    }

    @Test
    void parse() {
        ZonedDateTime parse = ZonedDateTime.parse("2022-05-26T08:44:19.516165500+08:00[Asia/Makassar]");
        System.out.println(parse);
    }

    @Test
    void change() {
        ZonedDateTime zonedDateTime = ZonedDateTime.now();
        System.out.println(zonedDateTime);

        ZonedDateTime zonedDateTime1 = zonedDateTime.withZoneSameInstant(ZoneId.of("Asia/Jakarta"));
        System.out.println(zonedDateTime1);
        ZonedDateTime zonedDateTime2 = zonedDateTime.withZoneSameLocal(ZoneId.of("Asia/Jakarta"));
        System.out.println(zonedDateTime2);

    }
}
