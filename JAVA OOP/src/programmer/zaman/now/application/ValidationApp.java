package programmer.zaman.now.application;

import programmer.zaman.now.data.LoginRequest;
import programmer.zaman.now.eror.ValidationException;
import programmer.zaman.now.util.Validation;
import programmer.zaman.now.util.Validation.*;

public class ValidationApp {
    public static void main(String[] args) {

        LoginRequest loginRequest =new LoginRequest(null,"rahasia");

        try {
            Validation.Validate(loginRequest);
            System.out.println("Data Valid");
        }catch(ValidationException|NullPointerException e){
            System.out.println("Terjadi error : "+e.getMessage());
        }finally {
            System.out.println("Selalu di eksekusi");
        }

        LoginRequest loginRequest2 = new LoginRequest(null,null);
        Validation.ValidateRuntime(loginRequest2);
    }
}
