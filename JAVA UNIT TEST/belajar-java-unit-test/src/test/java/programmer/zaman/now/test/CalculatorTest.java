package programmer.zaman.now.test;

import org.junit.jupiter.api.*;
import org.opentest4j.TestAbortedException;
import programmer.zaman.now.test.generator.SimpleDisplayNameGenerator;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.*;

@DisplayNameGeneration(SimpleDisplayNameGenerator.class)
//@DisplayName("Test untuk Calculator class")
public class CalculatorTest {

    private Calculator calculator = new Calculator();

    @BeforeAll
    public static void beforeAll(){
        System.out.println("After all");
    }

    @AfterAll
    public static void afterAll(){
        System.out.println("Before all");
    }

    @BeforeEach
    public void setUp(){
        System.out.println("Before each");
    }

    @AfterEach
    public void tearDown(){
        System.out.println("After each");
    }

    @Test
//    @DisplayName("Test skenario sukses untuk method add(integer, integer)")
    public void testAddSucces(){
        var result = calculator.add(10,10);
        assertEquals(20,result);
    }

    @Test
    public void testDevideSucces(){
        var result = calculator.devide(100, 10);
        assertEquals(10, result);
    }

    @Test
    public void testDevideFailed(){
        assertThrows(IllegalArgumentException.class, () -> calculator.devide(10, 0));
    }

    @Test
    @Disabled
    public void testComingSoon(){

    }

    @Test
    public void testAborted(){
        var profile = System.getenv("PROFILE");
        if (!"DEV".equals(profile)){
            throw new TestAbortedException("Test dibatalkan karena bukan DEV");
        }

        // unit test untuk DEV
    }

    @Test
    public void testAssumptions(){
        assumeTrue("DEV".equals(System.getenv("PROFILE")));
    }
}
