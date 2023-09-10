package programmer.zaman.now.validation;

import jakarta.validation.ConstraintViolation;
import org.hibernate.validator.internal.engine.MessageInterpolatorContext;
import org.hibernate.validator.messageinterpolation.ExpressionLanguageFeatureLevel;
import org.junit.jupiter.api.Test;

import java.util.Locale;
import java.util.Set;

public class MessageInternationalizationTest extends AbstractValidator{

    @Test
    void testMessageI18n() {
        var order = new Order();
        order.setId("");
        order.setAmount(5000L);

        Locale.setDefault(new Locale("in", "ID"));
        validate(order);
    }

    @Test
    void testMessageI18n2() {
        var order = new Order();
        order.setId("");
        order.setAmount(5000L);
//        Locale.setDefault(new Locale("in", "ID")); // tidak pakai ini bro

        Set<ConstraintViolation<Object>> violations = validator.validate(order);
        for (var violation:violations) {
            MessageInterpolatorContext messageInterpolatorContext = new MessageInterpolatorContext(
                    violation.getConstraintDescriptor(), violation.getInvalidValue(), violation.getRootBeanClass(),
                    violation.getPropertyPath(), violation.getConstraintDescriptor().getAttributes(),
                    violation.getConstraintDescriptor().getAttributes(),
                    ExpressionLanguageFeatureLevel.VARIABLES, true
            );
            String interpolate = messageInterpolator.interpolate(violation.getMessageTemplate(),
                    messageInterpolatorContext, new Locale("in", "ID"));
            System.out.println("=============");
            System.out.println(interpolate);
            System.out.println(violation.getPropertyPath());
        }
    }


}
