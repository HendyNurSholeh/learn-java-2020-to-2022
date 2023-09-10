package programmerzamannow.reflection;

import org.junit.jupiter.api.Test;
import programmerzamannow.reflection.data.*;

import javax.lang.model.element.NestingKind;
import java.lang.reflect.*;
import java.util.Arrays;
import java.util.List;

public class ParameterizeTypeTest {

    @Test
    void testMethodGeneric() throws NoSuchFieldException, IllegalAccessException, NoSuchMethodException {
        Class<Person> personClass = Person.class;
        Method getHobbies = personClass.getDeclaredMethod("getHobbies");
        Type genericReturnType = getHobbies.getGenericReturnType();
        if (genericReturnType instanceof ParameterizedType){
            ParameterizedType parameterizedType = (ParameterizedType) genericReturnType;
            System.out.println(parameterizedType.getTypeName());
            System.out.println(parameterizedType.getRawType());
            System.out.println(Arrays.toString(parameterizedType.getActualTypeArguments()));
        }
    }

    @Test
    void testParameterGeneric() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        var person = new Person();
        Class<Person> personClass = Person.class;
        Method setHobbies = personClass.getDeclaredMethod("setHobbies", List.class);
        for (var parameter:setHobbies.getGenericParameterTypes()) {
            if (parameter instanceof ParameterizedType){
                ParameterizedType parameterizedType = (ParameterizedType) parameter;
                System.out.println(parameterizedType.getTypeName());
                System.out.println(parameterizedType.getRawType());
                System.out.println(Arrays.toString(parameterizedType.getActualTypeArguments()));
            }
        }
    }

    @Test
    void testFieldGeneric() throws NoSuchFieldException {
        Class<Person> personClass = Person.class;
        Field hobbies = personClass.getDeclaredField("hobbies");
        Type genericType = hobbies.getGenericType();
        System.out.println(genericType.getClass());
        if (genericType instanceof ParameterizedType){
            ParameterizedType parameterizedType = (ParameterizedType) genericType;
            System.out.println(parameterizedType.getTypeName());
            System.out.println(parameterizedType.getRawType());
            System.out.println(Arrays.toString(parameterizedType.getActualTypeArguments()));
            System.out.println(parameterizedType.getOwnerType());
        }
    }

    @Test
    void testGenericTypeVariables() throws NoSuchFieldException {
        Class<Data> dataClass = Data.class;
        TypeVariable<Class<Data>>[] typeParameters = dataClass.getTypeParameters();
        for (var typeParameter:typeParameters) {
            System.out.println(typeParameter.getTypeName());
            System.out.println(typeParameter.getName());
            System.out.println(Arrays.toString(typeParameter.getBounds()));
            System.out.println(Arrays.toString(typeParameter.getAnnotatedBounds()));
            System.out.println(typeParameter.getGenericDeclaration());
        }
    }
}
