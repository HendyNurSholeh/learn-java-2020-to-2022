package programmerzamannow.reflection;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.Arrays;

public class ArrayTest {

    @Test
    void create() {
        Class<String[]> classString1 = String[].class;
        Class<String[][]> classString2 = String[][].class;
        Class<int[]> classInt1 = int[].class;
        Class<int[][]> classInt2 = int[][].class;

        System.out.println(classString1.isArray());
        System.out.println(Arrays.toString(classString1.getDeclaredMethods()));
        System.out.println(classString2.isArray());
        System.out.println(classInt1.isArray());
        System.out.println(classInt2.isArray());
    }

    @Test
    void mengaksesDataArray() {
        Class<String[]> aClass = String[].class;

        Object newInstance = Array.newInstance(aClass.getComponentType(), 10);

        Array.set(newInstance, 0, "usopp");
        System.out.println(Array.get(newInstance, 0));

        for (int i = 0; i < 10; i++) {
            Object value = Array.get(newInstance, i);
            System.out.print(value + ", ");
        }
    }


}
