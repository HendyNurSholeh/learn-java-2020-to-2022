package programmerzamannow.datetime;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.Period;

public class PeriodTest {


    @Test
    void create() {
        Period ofDays = Period.ofDays(1);
        Period ofMonths = Period.ofMonths(1);
        System.out.println(ofDays);
        System.out.println(ofMonths);
    }

    @Test
    void between() {
        Period period = Period.between(LocalDate.now().plusDays(1), LocalDate.now());
        System.out.println(period);
    }

}
