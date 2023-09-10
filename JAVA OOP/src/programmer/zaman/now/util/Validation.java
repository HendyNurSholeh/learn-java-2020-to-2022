package programmer.zaman.now.util;

import programmer.zaman.now.anotation.NotBlank;
import programmer.zaman.now.data.LoginRequest;
import programmer.zaman.now.eror.BlankException;
import programmer.zaman.now.eror.ValidationException;

import java.lang.reflect.Field;

public class Validation {
    public static void Validate (LoginRequest loginRequest) throws ValidationException, NullPointerException{
        if (loginRequest.userName()==null){
            throw new NullPointerException("UserName is null");
        }else if (loginRequest.userName().isBlank()) {
            throw new ValidationException("UserName is blank");
        }else if (loginRequest.password()== null) {
            throw new NullPointerException("Password is null");
        }else if (loginRequest.password().isBlank()) {
            throw new ValidationException("Password is blank");
        }
    }

    public static void ValidateRuntime (LoginRequest loginRequest){
        if (loginRequest.userName()==null){
            throw new NullPointerException("UserName is null");
        }else if (loginRequest.userName().isBlank()) {
            throw new BlankException("UserName is blank");
        }else if (loginRequest.password()== null) {
            throw new NullPointerException("Password is null");
        }else if (loginRequest.password().isBlank()) {
            throw new BlankException("Password is blank");
        }
    }
    public static void validationReflection(Object object){
        Class aClass = object.getClass();
        Field[] fields = aClass.getDeclaredFields();

        for (var field : fields){
            field.setAccessible(true);

            if (field.getAnnotation(NotBlank.class) != null){
                // validasi
                try {
                    String value = (String) field.get(object);

                    if (value == null||value.isBlank()){
                        throw new BlankException("Field "+ field.getName()+" is blank ");
                    }
                }catch (IllegalAccessException exception){
                    System.out.println("Tidak bisa mengakses field "+ field.getName());
                }
            }
        }
    }
}
