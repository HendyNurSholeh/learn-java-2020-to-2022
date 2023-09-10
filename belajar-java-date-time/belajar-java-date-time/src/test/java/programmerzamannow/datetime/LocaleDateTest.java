package programmerzamannow.datetime;

import net.bytebuddy.asm.Advice;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class LocaleDateTest {

    @Test
    void createLocalDate() {
        LocalDate now = LocalDate.now();
        LocalDate date = LocalDate.of(2004, 5, 16);
        LocalDate parse = LocalDate.parse("2004-05-16");

        System.out.println(now);
        System.out.println(date);
        System.out.println(parse);
    }

    @Test
    void withLocaleDate() {
        LocalDate now = LocalDate.now();
        LocalDate tahunLahir = now.withDayOfMonth(16).withMonth(5).withYear(2004);
        System.out.println(now);
        System.out.println(tahunLahir);
    }

    @Test
    void plusLocalDate() {
        LocalDate now = LocalDate.now();
        LocalDate localDatePlus = now.plusDays(1).plusMonths(2).plusYears(1);
        System.out.println(localDatePlus);
    }

    @Test
    void minusLocalDate() {
        LocalDate now = LocalDate.now();
        LocalDate minusYears = now.minusDays(10).minusMonths(1).minusYears(2);
        System.out.println(minusYears);
    }

    @Test
    void getLocalDate() {
        LocalDate now = LocalDate.now();
        System.out.println(now.getYear());
        System.out.println(now.getMonth());
        System.out.println(now.getDayOfMonth());
    }
}
