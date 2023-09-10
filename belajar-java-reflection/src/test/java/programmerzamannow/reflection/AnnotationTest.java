package programmerzamannow.reflection;

import org.junit.jupiter.api.Test;
import programmerzamannow.reflection.annotation.NotBlank;
import programmerzamannow.reflection.data.Person;
import programmerzamannow.reflection.validator.Validator;

import java.util.Arrays;

public class AnnotationTest {

    @Test
    void create() {
        Class<Person> personClass = Person.class;
        System.out.println(Arrays.toString(personClass.getAnnotations()));
    }

    @Test
    void testAnnotationWithRefection() throws IllegalAccessException {
        var person = new Person();
        person.setFirstName(" ");
        person.setLastName("  ");
        Validator.validateNotBlank(person);
    }
}
