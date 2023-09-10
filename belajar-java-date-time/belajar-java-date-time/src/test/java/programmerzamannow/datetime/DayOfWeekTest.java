package programmerzamannow.datetime;

import org.junit.jupiter.api.Test;

import java.time.DayOfWeek;

public class DayOfWeekTest {

    @Test
    void create() {
        DayOfWeek monday = DayOfWeek.MONDAY;
        System.out.println(monday);
        System.out.println(monday.plus(1));
        System.out.println(monday.minus(1));
    }
}
