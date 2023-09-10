package programmer.zaman.now.utility;

import javax.swing.text.DateFormatter;
import java.text.MessageFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;

public class TimeUtil {

    private static Clock clock = Clock.systemDefaultZone();

    public static String getTime() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss", ResouceBundleUtil.getResourceBundle().getLocale());

        String date = LocalDate.now(clock).toString();
        String time = LocalTime.now(clock).format(formatter);

        String string = ResouceBundleUtil.getResourceBundle().getString("time.now");

        String timeAndDate = MessageFormat.format(string, new Object[]{date, time});
        return timeAndDate;
    }
}
