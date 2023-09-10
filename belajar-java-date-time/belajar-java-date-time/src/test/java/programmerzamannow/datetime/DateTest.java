package programmerzamannow.datetime;

import org.junit.jupiter.api.Test;

import java.util.Date;

public class DateTest {

    @Test
    void testCreateDate() {
        var date = new Date();
        var date2 = new Date(System.currentTimeMillis());
        System.out.println(date);
        System.out.println(date2);
    }
}
