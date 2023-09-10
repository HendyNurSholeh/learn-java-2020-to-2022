package programmer.zaman.now;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import programmer.zaman.now.generator.RandomParameterResolver;

import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RandomCalculatorTest extends ParentCalculatorTest{


    @RepeatedTest(value = 5, name = "{displayName} ke {currentRepetition} dari {totalRepetitions}")
    void testRandom(Random random) {
        var a = random.nextInt();
        var b = random.nextInt();

        var result = calculator.add(a, b);

        Assertions.assertEquals(a + b, result);

        System.out.println(result);
    }

    @RepeatedTest(value = 10, name = "{displayName} ke {currentRepetition} dari {totalRepetitions}")
    @DisplayName("test random")
    void testRandomRepetitionInfo(RepetitionInfo repetitionInfo, TestInfo info) {
        System.out.println(info.getDisplayName() + " ke " +
                repetitionInfo.getCurrentRepetition() + " dari " + repetitionInfo.getTotalRepetitions());
    }

    @Test
    void calculatorAdd(Random random) {
        var a = random.nextInt();
        var b = random.nextInt();

        var result = calculator.add(a, b);

        Assertions.assertEquals(a + b, result);
    }


    @ParameterizedTest(name = "{displayName} dengan parameter {0}")
    @DisplayName("Test Calculator")
    @ValueSource(ints = {1,2,3,7,3,9,12})
    void testWithParameter(int value) {
        var value1 = value;
        var value2 = value;

        Integer testAdd = calculator.add(value1, value2);

        assertEquals(value1 + value2, testAdd);

    }


    static List<String> names(){
        return List.of("hendy", "nur", "sholeh");
    }

    @DisplayName("Test static method")
    @ParameterizedTest(name = "{displayName} dengan parameter {0}")
    @MethodSource(value = {"names"})
    void testNames(String name) {
        System.out.println(name);
    }

}
