package programmerzamannow.reflection;

import org.junit.jupiter.api.Test;
import programmerzamannow.reflection.data.DataPasien;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

public class RecordTest {

    @Test
    void testRecord() {
        Class<DataPasien> dataPasienClass = DataPasien.class;
        System.out.println(Arrays.toString(dataPasienClass.getDeclaredMethods()));
        System.out.println(Arrays.toString(dataPasienClass.getDeclaredFields()));
        System.out.println(Arrays.toString(dataPasienClass.getDeclaredConstructors()));
        System.out.println(dataPasienClass.isRecord());
        System.out.println(dataPasienClass.getSuperclass());
        System.out.println(Arrays.toString(dataPasienClass.getRecordComponents()));
        for (var component:dataPasienClass.getRecordComponents()) {
            System.out.println(component.getName());
            System.out.println(component.getAccessor());
            System.out.println(component.getDeclaringRecord());
            System.out.println(component.getType());
            System.out.println(component.getGenericType());
            System.out.println("================");
        }
    }

    @Test
    void testGetRecordManual() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        var dataPasien = new DataPasien("bambang", "panas dalam", 10);

        Class<DataPasien> dataPasienClass = DataPasien.class;
        Method name = dataPasienClass.getDeclaredMethod("name");
        Object invoke = name.invoke(dataPasien);
        System.out.println(invoke);
    }

    @Test
    void testGetMethodByComponents() throws InvocationTargetException, IllegalAccessException {
        var dataPasien = new DataPasien("usopp", "tangah keseleo", 1000);

        Class<DataPasien> dataPasienClass = DataPasien.class;
        for (var component:dataPasienClass.getRecordComponents()) {
            Method accessor = component.getAccessor();
            System.out.println(accessor);
            System.out.println(accessor.getName());
            System.out.println(accessor.invoke(dataPasien));
        }


    }
}
