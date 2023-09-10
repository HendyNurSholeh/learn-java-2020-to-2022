package programmer.zaman.now;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.*;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.opentest4j.TestAbortedException;
import programmer.zaman.now.generator.SimpleGeneratorDisplayName;

import java.util.List;

//@DisplayName("Test Calculator")
@DisplayNameGeneration(SimpleGeneratorDisplayName.class)
public class CalculatorTest {
    private Calculator calculator = new Calculator();

    @BeforeAll
    public static void beforeAll(){
        System.out.println("ini adalah before all");
    }

    @AfterAll
    public static void afterAll(){
        System.out.println("ini adalah after all");
    }

    @BeforeEach
    public void beforeEach(){
        System.out.println("ini adalah before each");
    }

    @AfterEach
    public void afterEach(){
        System.out.println("ini adalah after each");
    }


    @Test
//    @DisplayName("Test method add(Integer, Integer)")
    public void testAddSuccess(){
        var result = calculator.add(5,8);
        assertEquals(13, result);
    }

    @Test
    @Disabled
    public void testDivideSuccess(){
        var result = calculator.divide(10,2);
        assertEquals(5, result);
    }

    @Test
    public void testDivideFalse(){
        assertThrows(IllegalArgumentException.class, () -> calculator.divide(10, 0));
    }

    @Test
    public void testAbortedException(){
        var profile = System.getenv("PROFILE");
        assumeTrue(profile.equals("DEV"), "TEST DIBATALKAN");
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
    @ParameterizedTest(name = "{displayname} dengan parameter {0}")
    @MethodSource(value = {"names"})
    void testNames(List<String> name) {
        for (var index : name) {
            System.out.println(index);
        }
    }


}
