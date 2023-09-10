package programmerzamannow.datetime;

import org.junit.jupiter.api.Test;

import java.time.ZoneId;
import java.time.ZoneOffset;

public class ZoneTest {

    @Test
    void zoneId() {
        ZoneId.getAvailableZoneIds().forEach(zone -> System.out.println(zone));
        ZoneId aDefault = ZoneId.systemDefault();
        ZoneId jakarta = ZoneId.of("Asia/Jakarta");
        System.out.println(aDefault.getRules());
        System.out.println(jakarta.getRules());
    }

    @Test
    void zoneOffset() {
        ZoneOffset hoursMinutes = ZoneOffset.ofHoursMinutes(5, 30);
        ZoneOffset of = ZoneOffset.of("-02:00");
        ZoneOffset zoneOffset = ZoneOffset.ofHours(8);
        System.out.println(hoursMinutes);
        System.out.println(of);
        System.out.println(zoneOffset);
    }
}
