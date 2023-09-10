package programmer.zaman.now.validation.payload;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Payload;

public class SendMessageErrorPayload implements Payload {

    public static void sendError(ConstraintViolation<?> violation){
        System.out.println("error : " + violation.getMessage() + "path : " + violation.getPropertyPath());
    }
}
