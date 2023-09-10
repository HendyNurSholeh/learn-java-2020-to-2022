package programmerzamannow.datetime;

import jdk.swing.interop.SwingInterOpUtils;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;

import java.time.*;

public class YearMonthAndMonthDayTest {

    @Test
    void year() {
        Year now = Year.now();
        Year of = Year.of(2022);
        Year parse = Year.parse("2022");
        System.out.println(now);
        System.out.println(of);
        System.out.println(parse);
        YearMonth now1 = YearMonth.now();
        System.out.println(now1);
    }

    @Test
    void month() {
        Month of = Month.of(5);
        System.out.println(of);
    }

    @Test
    void monthDay() {
        MonthDay now = MonthDay.now();
        MonthDay of = MonthDay.of(5, 16);
        MonthDay.parse("--05-16");
        System.out.println(now);
        System.out.println(of);
    }

    @Test
    void convertToDate() {
        Year year = Year.of(2000);
        YearMonth yearMonth = year.atMonth(05);
        LocalDate localDate = yearMonth.atDay(10);
        System.out.println(localDate);
        YearMonth from2 = YearMonth.from(localDate);
        Year from1 = Year.from(from2);
        MonthDay from3 = MonthDay.from(localDate);
        System.out.println(from1);
        System.out.println(from2);
        System.out.println(from3);
    }
}
