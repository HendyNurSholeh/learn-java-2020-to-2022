package programmer.zaman.now;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

@DisplayName("information test")
public class InformationTest {

    @Test
    @Tag("one")
    @DisplayName("this is test 1")
    void informationTest(TestInfo infoTest) {
        System.out.println(infoTest.getDisplayName());
        System.out.println(infoTest.getTags());
        System.out.println(infoTest.getTestClass().orElse(null));
        System.out.println(infoTest.getTestMethod().orElse(null));

    }
}
