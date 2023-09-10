package programmerzamannow.lombok;

import org.junit.jupiter.api.Test;

public class PersonTest {

    @Test
    void testPersonBuilder() {
        Person person = Person.builder().id("123").name("hendy").hobby("mandi").build();
        System.out.println(person);
    }
}
