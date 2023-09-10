package programmerzamannow.datetime;

import net.bytebuddy.asm.Advice;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class DateTimeFormatterTest {

    @Test
    void localDate() {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy MM dd");
        LocalDate localDate = LocalDate.parse("2020 05 16", dateTimeFormatter);
        System.out.println(localDate);
    }

    @Test
    void localDateTime() {
        Locale indonesia = new Locale("in", "ID");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEEE, yyyy MM dd", indonesia);
        LocalDateTime now = LocalDateTime.now();
        System.out.println(now.format(formatter));
    }

    @Test
    void defaultFormatter() {
        LocalDateTime localDateTime = LocalDateTime.now();
        String format = localDateTime.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
        System.out.println(format);
    }

    @Test
    void i18n() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy MMMM dd");
        String format = LocalDate.now().format(formatter);
        System.out.println(format);
    }
}
