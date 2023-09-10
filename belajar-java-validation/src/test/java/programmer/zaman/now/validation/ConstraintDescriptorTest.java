package programmer.zaman.now.validation;

import jakarta.validation.ConstraintViolation;
import org.junit.jupiter.api.Test;

import java.util.Set;

public class ConstraintDescriptorTest extends AbstractValidator{

    @Test
    void testMethodConstraintDescriptor() {
        var person = new Person();

        Set<ConstraintViolation<Person>> violations = validator.validate(person);
        for (var violation:violations) {
            System.out.println("================");
            System.out.println(violation.getConstraintDescriptor().getAnnotation());
            System.out.println(violation.getConstraintDescriptor().getAttributes());
            System.out.println(violation.getConstraintDescriptor().getPayload());
            System.out.println(violation.getConstraintDescriptor().getMessageTemplate());
            System.out.println(violation.getConstraintDescriptor().getGroups());
            System.out.println(violation.getConstraintDescriptor().getComposingConstraints());
        }

    }
}
