package programmerzamannow.reflection;

import org.junit.jupiter.api.Test;
import programmerzamannow.reflection.data.Level;
import programmerzamannow.reflection.data.Person;

import java.util.Arrays;

public class EnumTest {

    @Test
    void testEnum() {
        Class<Level> levelClass = Level.class;
        System.out.println(levelClass.getSimpleName());
        System.out.println(levelClass.isEnum());
        System.out.println(levelClass.getSuperclass());
        System.out.println(Arrays.toString(levelClass.getEnumConstants()));
        System.out.println(Arrays.toString(levelClass.getDeclaredConstructors()));
        System.out.println(Arrays.toString(levelClass.getDeclaredFields()));
        System.out.println(Arrays.toString(levelClass.getDeclaredMethods()));
    }
}
