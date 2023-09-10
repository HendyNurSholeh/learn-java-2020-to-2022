package programmer.zaman.now.validation;

import jakarta.validation.metadata.BeanDescriptor;
import jakarta.validation.metadata.PropertyDescriptor;
import org.junit.jupiter.api.Test;

import javax.xml.validation.Validator;
import java.time.Period;
import java.util.Set;

public class MetaDataTest extends AbstractValidator {

    @Test
    void testMetaData() {
        BeanDescriptor constraintsForClass = validator.getConstraintsForClass(Person.class);
        Set<PropertyDescriptor> constrainedProperties = constraintsForClass.getConstrainedProperties();
        for (var property:constrainedProperties) {
            System.out.println(property.getPropertyName());
            for (var descriptor:property.getConstraintDescriptors()) {
                System.out.println(descriptor);
            }
        }
    }
}
