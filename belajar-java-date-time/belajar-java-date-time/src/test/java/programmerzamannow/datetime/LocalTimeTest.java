package programmerzamannow.datetime;

import net.bytebuddy.asm.Advice;
import org.junit.jupiter.api.Test;

import java.time.LocalTime;

public class LocalTimeTest {

    @Test
    void create() {
        LocalTime now = LocalTime.now();
        LocalTime of = LocalTime.of(13, 30);
        LocalTime parse = LocalTime.parse("13:30");

        System.out.println(now);
        System.out.println(of);
        System.out.println(parse);
        System.out.println(now.getHour() + ":" + now.getMinute());
    }

    @Test
    void with() {
        LocalTime now = LocalTime.now();
        LocalTime with= now.withHour(15).withMinute(0).withSecond(0).withNano(0);
        System.out.println(with);
    }

    @Test
    void plusAndMinus() {
        LocalTime time = LocalTime.of(00, 00, 00);
        LocalTime plus = time.plusHours(1).plusMinutes(1).plusSeconds(1);
        LocalTime minus = time.minusHours(1).minusMinutes(1).minusSeconds(1);
        System.out.println(plus);
        System.out.println(minus);
    }

    @Test
    void get() {
        LocalTime time = LocalTime.parse("14:40");
        int hour = time.getHour();
        int minute = time.getMinute();
        System.out.println(hour);
        System.out.println(minute);
    }

}
