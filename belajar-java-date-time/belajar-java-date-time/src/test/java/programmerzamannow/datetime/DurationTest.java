package programmerzamannow.datetime;

import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.LocalTime;

public class DurationTest {

    @Test
    void create() {
        Duration duration = Duration.ofDays(1);
        Duration duration1 = Duration.ofHours(1);
        Duration duration2 = Duration.ofMinutes(1);
        Duration duration3 = Duration.ofNanos(6000000);

        System.out.println(duration.toDays());
        System.out.println(duration1);
        System.out.println(duration2);
        System.out.println(duration3);
    }

    @Test
    void between() {
        Duration duration = Duration.between(LocalTime.of(12, 30, 30), LocalTime.of(15, 5));
        System.out.println(duration);
        Duration duration2 = Duration.between(LocalTime.of(15, 5), LocalTime.of(12, 30, 30));
        System.out.println(duration2);

    }
}
