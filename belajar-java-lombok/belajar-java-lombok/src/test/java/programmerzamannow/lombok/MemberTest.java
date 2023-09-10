package programmerzamannow.lombok;

import org.junit.jupiter.api.Test;

public class MemberTest {

    @Test
    void testNonNull() {
        var member1 = new Member("123", "hendy");
        var member2 = new Member();
    }

    @Test
    void testSayHello() {
        new Member().sayHello("ganteng");
    }
}
