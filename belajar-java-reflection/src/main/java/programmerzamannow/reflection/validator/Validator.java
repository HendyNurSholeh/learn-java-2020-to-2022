package programmerzamannow.reflection.validator;

import programmerzamannow.reflection.annotation.NotBlank;

import java.lang.reflect.Field;

public class Validator {
    public static void validateNotBlank(Object object) throws IllegalAccessException {
        Class<?> aClass = object.getClass();
        Field[] declaredFields = aClass.getDeclaredFields();
        for (var field : declaredFields) {
            field.setAccessible(true);
            NotBlank annotation = field.getAnnotation(NotBlank.class);
            if (annotation != null) {
                String value = (String) field.get(object);
                if(!annotation.allowEmptyString()){
                    value = value.trim();
                }
                if (value == null || value.equals("")){
                    throw new RuntimeException("value " + field.getName() + " null/empty broo, isi dulu lah");
                }
//                if (annotation.allowEmptyString()){
//                    if (value == null || value.isEmpty()){
//                        throw new RuntimeException("valuenya null/empty broo, isi dulu lah");
//                    }
//                }else {
//                    if (value == null || value.isBlank()){
//                        throw new RuntimeException("valuenya blank/null broo, isi dulu lah");
//                    }
//                }
            }
        }
        System.out.println("Aman BRoooo");
    }
}
