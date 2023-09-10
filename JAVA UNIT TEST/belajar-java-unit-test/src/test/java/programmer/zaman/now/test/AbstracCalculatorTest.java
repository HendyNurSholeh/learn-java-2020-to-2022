package programmer.zaman.now.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.Extensions;
import programmer.zaman.now.test.resolver.RandomParameterResolver;

@Extensions({
        @ExtendWith(RandomParameterResolver.class)
})
public class AbstracCalculatorTest {
    public Calculator calculator = new Calculator();

    @BeforeEach
    void setUp(){
        System.out.println("Before each");
    }
}
