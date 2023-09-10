package programmer.zaman.now.validation;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class ContainerDataTest extends AbstractValidator{

    @Test
    void testContainerData() {
        var person = new Person();

        person.setFirtsName("hendy");
        person.setLastName("nur sholeh");
        person.setAddress(new Address("kalsel", "tanah laut", "nur sehat"));
        person.setHobbies(List.of("eko", "joko", "hendy"));

        validate(person);
    }
}
