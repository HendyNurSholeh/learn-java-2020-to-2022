package programmer.zaman.now.i18n;

import org.junit.jupiter.api.Test;

import java.text.ChoiceFormat;
import java.text.MessageFormat;
import java.util.Locale;
import java.util.ResourceBundle;

public class ChoiceFormatTest {

    @Test
    void testChoiceFormat() {
        var pattern = "-1#negatif | 0#kosong | 1#satu | 1<banyak";
        ChoiceFormat choiceFormat = new ChoiceFormat(pattern);
        String format = choiceFormat.format(-5);
        System.out.println(format);
    }

    @Test
    void testMessageChoiceFormat() {
        var country = new Locale("in", "ID");
        ResourceBundle resourceBundle = ResourceBundle.getBundle("message", country);
        String pattern = resourceBundle.getString("balance");

        MessageFormat messageFormat = new MessageFormat(pattern, country);
        String format = messageFormat.format(new Object[]{10000});
        System.out.println(format);
    }

    @Test
    void testMessageChoiceFormatUS() {
        var country = new Locale("en", "US");
        ResourceBundle resourceBundle = ResourceBundle.getBundle("message", country);
        String pattern = resourceBundle.getString("balance");

        MessageFormat messageFormat = new MessageFormat(pattern, country);
        String format = messageFormat.format(new Object[]{10000});
        System.out.println(format);
    }
}
