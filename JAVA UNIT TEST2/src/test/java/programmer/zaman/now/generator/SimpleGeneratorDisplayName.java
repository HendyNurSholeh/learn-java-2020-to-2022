package programmer.zaman.now.generator;

import org.junit.jupiter.api.ClassOrderer;
import org.junit.jupiter.api.DisplayNameGenerator;

import java.lang.reflect.Method;

public class SimpleGeneratorDisplayName implements DisplayNameGenerator {
    @Override
    public String generateDisplayNameForClass(Class<?> aClass) {
        return "Test " + aClass.getSimpleName();
    }

    @Override
    public String generateDisplayNameForMethod(Class<?> aClass, Method method) {
        return "Test " + aClass.getSimpleName() + "." + method.getName();
    }

    @Override
    public String generateDisplayNameForNestedClass(Class<?> aClass) {
        return null;
    }
}
