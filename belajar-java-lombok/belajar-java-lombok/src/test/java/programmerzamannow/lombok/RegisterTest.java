package programmerzamannow.lombok;

import org.junit.jupiter.api.Test;

public class RegisterTest {

    @Test
    void testFinal() {
        var register = new Register("hendy", "hendy123");
        var register2 = register.withUserName("joko");
        System.out.println(register);
        System.out.println(register2);
    }
}
