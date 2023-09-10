package programmer.zaman.now.i18n;

import org.junit.jupiter.api.Test;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

public class NumberFormatTest {

    @Test
    void testNumberFormat() {
        NumberFormat numberFormat = NumberFormat.getInstance();
        String format = numberFormat.format(20000.20);
        System.out.println(format);
    }

    @Test
    void testNumberFormatIndonesia() {
        var indonesia = new Locale("in", "ID");
        NumberFormat numberFormat = NumberFormat.getInstance(indonesia);
        String format = numberFormat.format(20000.20);
        System.out.println(format);
    }

    @Test
    void testNumberFormatParseIndonesia() throws ParseException {
        var indonesia = new Locale("in", "ID");
        NumberFormat numberFormat = NumberFormat.getInstance(indonesia);
        double value = numberFormat.parse("10.000,255").doubleValue();
        System.out.println(value);
    }
}
