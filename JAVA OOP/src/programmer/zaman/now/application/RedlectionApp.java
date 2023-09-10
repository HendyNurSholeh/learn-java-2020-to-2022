package programmer.zaman.now.application;

import programmer.zaman.now.data.CreateUserRequest;
import programmer.zaman.now.util.Validation;

public class RedlectionApp {
    public static void main(String[] args) {

        CreateUserRequest request = new CreateUserRequest();
        request.setUsername("eko");
        request.setPassword("eko");
        request.setName("eko");
        Validation.validationReflection(request);
    }
}
