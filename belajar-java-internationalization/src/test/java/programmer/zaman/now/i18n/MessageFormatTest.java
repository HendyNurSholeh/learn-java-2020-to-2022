package programmer.zaman.now.i18n;

import org.junit.jupiter.api.Test;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.ResourceBundle;

public class MessageFormatTest {

    @Test
    void testMesageFormat() {
        var format = "Hi {0} selamat datang di aplikasi todolist ya \"{0}\"";
        var messageFormat = new MessageFormat(format);
        var text = messageFormat.format(new Object[]{"eko"});
        System.out.println(text);
    }

    @Test
    void testMessageFormatWithResourceBundle() {
        var indonesia = new Locale("in", "ID");
        ResourceBundle resourceBundle = ResourceBundle.getBundle("message", indonesia);
        String pattern = resourceBundle.getString("welcome");

        MessageFormat messageFormat = new MessageFormat(pattern);
        String welcome = messageFormat.format(new Object[]{"youndaeme"});
        System.out.println(welcome);
    }
}
