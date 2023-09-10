package programmer.zaman.now.i18n;

import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DateFormatTest {

    @Test
    void testDateFormat() throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd MMMM yyyy");
//        System.out.println(dateFormat.format(new Date()));
        System.out.println(dateFormat.format(new Date()));
        String dob = "16 July 2004";
        Date date = dateFormat.parse(dob);
        System.out.println(date.toString());
    }

    @Test
    void testDateFormatIndonesia() throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("EEEE dd MMMM yyyy", new Locale("in", "ID"));
        System.out.println(dateFormat.format(new Date()));
        String dob = "minggu 16 Juli 2004";
        Date date = dateFormat.parse(dob);
        System.out.println(date.toString());
    }

    @Test
    void testDateFormatjapan() throws ParseException {
        var japan = new Locale("ja", "JP");
        SimpleDateFormat dateFormat = new SimpleDateFormat("EEEE dd MMMM yyyy", japan);
        System.out.println(dateFormat.format(new Date()));
//        String dob = "minggu 16 Juli 2004";
//        Date date = dateFormat.parse(dob);
//        System.out.println(date.toString());
    }

    @Test
    void testDateFormatParseIndonesia() {
        var pattern = "EEEE dd MMMM yyyy";
        var indonesia = new Locale("in", "ID");
        SimpleDateFormat dateFormat = new SimpleDateFormat(pattern, indonesia);
        try{
            Date date = dateFormat.parse("minggu 22 juli 2022");
            System.out.println(date.toString());
        }catch (ParseException exception){
            System.out.println("Error : " + exception.getMessage());
        }
    }
}
