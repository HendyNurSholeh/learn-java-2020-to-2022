package programmer.zaman.now.i18n;

import org.junit.jupiter.api.Test;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Currency;
import java.util.Locale;

public class CurrencyTest {

    @Test
    void tetCurrencyIndonesia() {
        var indonesia = new Locale("in", "ID");
        Currency currency = Currency.getInstance(indonesia);
        System.out.println(currency.getDisplayName());
        System.out.println(currency.getCurrencyCode());
        System.out.println(currency.getSymbol(indonesia));
    }

    @Test
    void tetCurrencyEnglish() {
        var inggris = new Locale("en", "US");
        Currency currency = Currency.getInstance(inggris);
        System.out.println(currency.getDisplayName());
        System.out.println(currency.getCurrencyCode());
        System.out.println(currency.getSymbol(inggris));
    }

    @Test
    void tetCurrencyNumberFormat() {
        var america = new Locale("en", "US");
        NumberFormat numberFormat = NumberFormat.getCurrencyInstance(america);
        String format = numberFormat.format(10000.25);
        System.out.println(format);
    }

    @Test
    void tetCurrencyNumberFormatParse() throws ParseException {
        var indonesia = new Locale("in", "ID");
        NumberFormat numberFormat = NumberFormat.getCurrencyInstance(indonesia);
        Number parse = numberFormat.parse("Rp10.000,25");
        System.out.println(parse);
    }
}
