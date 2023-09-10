package programmer.zaman.now.i18n;

import org.junit.jupiter.api.Test;

import java.awt.*;
import java.text.MessageFormat;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;

public class MessageFormatTypeTest {

    @Test
    void testMessageFormatType() {
        var indonesia = new Locale("in", "ID");
        var resourceBundle = ResourceBundle.getBundle("message", indonesia);
        String status = resourceBundle.getString("status");

        MessageFormat messageFormat = new MessageFormat(status, indonesia);
        String format = messageFormat.format(new Object[]{"hendy", new Date(), 1000000});
        System.out.println(format);
    }
}
