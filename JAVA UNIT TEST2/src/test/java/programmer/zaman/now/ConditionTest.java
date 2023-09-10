package programmer.zaman.now;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.*;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

import java.util.Collections;
import java.util.Properties;

@Execution(ExecutionMode.CONCURRENT)
@Tag("Test-Condition")
public class ConditionTest {

    @Test
    @EnabledOnOs(OS.WINDOWS)
    public void testEnabledOnWindows() throws InterruptedException {
        Thread.sleep(10000);
    }

    @Test
    @DisabledOnOs(OS.WINDOWS)
    public void testDisabledOnWindows() {
    }

    @Test
    @EnabledOnJre(JRE.JAVA_16)
    public void testEnabledOnJRE16() throws InterruptedException {
        Thread.sleep(10000);
    }

    @Test
    @DisabledOnJre(JRE.JAVA_16)
    public void testDisabledOnJRE16(){

    }

    @Test
    @EnabledForJreRange(max = JRE.JAVA_16, min = JRE.JAVA_8)
    public void testEnabledForRangeJRE16() throws InterruptedException {
        Thread.sleep(10000);

    }

    @Test
    @DisabledForJreRange(max = JRE.JAVA_16, min = JRE.JAVA_8)
    public void testDisabledForRangeJRE16(){

    }

    @Test
    @DisabledIfEnvironmentVariable(named = "PROFILE", matches = "DEV")
    public void testDisabledIfProfileDev(){

    }

    @Test
    @EnabledIfEnvironmentVariable(named = "PROFILE", matches = "DEV")
    public void testEnabledIfProfileDev(){

    }

    @Test
    @DisabledIfSystemProperty(named = "java.vendor", matches = "Oracle Corporation")
    public void testDisableOracleCorporation() {

    }

    @Test
    @EnabledIfSystemProperty(named = "java.vendor", matches = "Oracle Corporation")
    public void testEnabledOracleCorporation() {

    }



}
