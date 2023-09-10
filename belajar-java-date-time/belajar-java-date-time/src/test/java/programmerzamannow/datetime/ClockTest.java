package programmerzamannow.datetime;

import org.junit.jupiter.api.Test;

import java.time.*;

public class ClockTest {

    @Test
    void create() {
        Clock clock = Clock.systemDefaultZone();
        Clock clock1 = Clock.systemUTC();
        Clock clock2 = Clock.system(ZoneId.of("Asia/Jakarta"));
        System.out.println(clock.getZone());
        System.out.println(clock1.getZone());
        System.out.println(clock2.getZone());
    }

    @Test
    void instant() throws InterruptedException {
        Clock clock = Clock.systemDefaultZone();
        System.out.println(clock.instant());
        Thread.sleep(5_000);
        System.out.println(clock.instant());
    }

    @Test
    void convert() {
        Clock clock = Clock.systemDefaultZone();
        LocalDateTime localDateTime = LocalDateTime.now(clock);
        ZonedDateTime zonedDateTime = ZonedDateTime.now(clock);
        System.out.println(localDateTime);
        System.out.println(zonedDateTime);
    }
}
