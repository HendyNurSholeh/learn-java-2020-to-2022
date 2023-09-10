package programmer.zaman.now;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import programmer.zaman.now.generator.RandomParameterResolver;

@ExtendWith(RandomParameterResolver.class)
public class ParentCalculatorTest {

    Calculator calculator = new Calculator();

    @BeforeEach
    void setUp() {
        System.out.println("Before Each");
    }

}
