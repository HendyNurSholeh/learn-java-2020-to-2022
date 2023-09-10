package programmerzamannow.lombok;

import org.junit.jupiter.api.Test;

public class LoginTest {

    @Test
    void testModifier() {
        var login = new Login();
        login.setUserName("hendy");
        login.setPassword("hendy123");
        System.out.println(login);
    }

}
