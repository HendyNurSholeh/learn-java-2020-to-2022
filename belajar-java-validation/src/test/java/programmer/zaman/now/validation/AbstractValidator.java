package programmer.zaman.now.validation;

import jakarta.validation.*;
import jakarta.validation.executable.ExecutableValidator;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import programmer.zaman.now.validation.container.ContainerNumber;
import programmer.zaman.now.validation.extractor.ContainerExtractor;
import programmer.zaman.now.validation.extractor.ContainerNumberValueExtractor;
import programmer.zaman.now.validation.extractor.KeyValueContainerEtractorKey;
import programmer.zaman.now.validation.extractor.KeyValueContainerEtractorValue;
import programmer.zaman.now.validation.payload.SendMessageErrorPayload;

import java.util.Locale;
import java.util.Set;

public abstract class AbstractValidator {

     protected ValidatorFactory validatorFactory = Validation.byDefaultProvider().configure()
             .addValueExtractor(new ContainerExtractor())
             .addValueExtractor(new KeyValueContainerEtractorKey())
             .addValueExtractor(new KeyValueContainerEtractorValue())
             .addValueExtractor(new ContainerNumberValueExtractor())
             .buildValidatorFactory();

     protected Validator validator = validatorFactory.getValidator();

     protected ExecutableValidator executableValidator = validator.forExecutables();

     protected MessageInterpolator messageInterpolator = validatorFactory.getMessageInterpolator();


    @AfterEach
    void tearDown() {
        validatorFactory.close();
    }

    public void validate(Object object){
        Set<ConstraintViolation<Object>> violations = validator.validate(object);
        for (var result:violations) {
            System.out.println("=============");
            System.out.println(result.getMessage());
            System.out.println(result.getPropertyPath());
        }
    }

     public void validateWithGrup(Object object, Class<?>... grups){
        Set<ConstraintViolation<Object>> violations = validator.validate(object, grups);
        for (var result:violations) {
            System.out.println("=============");
            System.out.println(result.getPropertyPath());
            System.out.println(result.getMessage());
        }
    }

    public void validateWithGrupAndPayment(Object object, Class<?>... grups){
        Set<ConstraintViolation<Object>> violations = validator.validate(object, grups);
        for (var result:violations) {
            System.out.println("=============");
            System.out.println(result.getPropertyPath());
            System.out.println(result.getMessage());
            Set<Class<? extends Payload>> payload = result.getConstraintDescriptor().getPayload();
            for (var aClassPayload:payload) {
                if (aClassPayload == SendMessageErrorPayload.class){
                    SendMessageErrorPayload.sendError(result);
                }
            }
        }
    }

}
