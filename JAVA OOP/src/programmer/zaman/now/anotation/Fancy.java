package programmer.zaman.now.anotation;

import java.lang.annotation.*;
import java.lang.reflect.Type;

@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Fancy {

    String name();

    String[] tags() default {};

}
