package programmer.zaman.now;

import org.junit.jupiter.api.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.MethodName.class)
public class OrderedTest {

    private Integer count = 0;

    @Test
    void test1() {
        count +=2;
        System.out.println(count);
    }

    @Test
    void test2() {
        count +=2;
        System.out.println(count);
    }

    @Test
    void test3() {
        count +=2;
        System.out.println(count);
    }
}
