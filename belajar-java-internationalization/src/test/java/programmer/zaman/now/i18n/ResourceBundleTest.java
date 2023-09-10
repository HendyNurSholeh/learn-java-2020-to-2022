package programmer.zaman.now.i18n;

import org.junit.jupiter.api.Test;

import java.util.Locale;
import java.util.ResourceBundle;

public class ResourceBundleTest {

    @Test
    void testResourceBundle() {
        var resourceBundle = ResourceBundle.getBundle("message");

        System.out.println(resourceBundle.getString("hello"));
        System.out.println(resourceBundle.getString("goodbye"));
    }

    @Test
    void testResourceBundleIndonesia() {
        var indonesia = new Locale("IN", "ID");
        var resourceBundle = ResourceBundle.getBundle("message", indonesia);

        System.out.println(resourceBundle.getString("hello"));
        System.out.println(resourceBundle.getString("goodbye"));
    }

    @Test
    void testResourceBundleMultipleTimes() {
        var indonesia = new Locale("IN", "ID");
        var resourceBundle = ResourceBundle.getBundle("message", indonesia);
        var resourceBundle2 = ResourceBundle.getBundle("message", indonesia);

        System.out.println(resourceBundle.equals(resourceBundle2));
        System.out.println(resourceBundle == resourceBundle2);
    }



}
