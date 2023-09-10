package programmer.zaman.now.test;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.condition.*;

import java.beans.JavaBean;

public class ConditionTest {

    @Test
    @EnabledOnOs(OS.WINDOWS)
    public void testRunOnlyOnWindows(){

    }

    @Test
    @DisabledOnOs(OS.WINDOWS)
    public void testDisabledOnWindows(){

    }


    @Test
    @EnabledOnJre(JRE.JAVA_8)
    public void testEnabledOnJava8(){

    }

    @Test
    @DisabledOnJre(JRE.JAVA_8)
    public void testDisabledOnJava8(){

    }

    @Test
    @EnabledForJreRange(min = JRE.JAVA_8, max = JRE.JAVA_16)
    public void testEnabledForJava8To16(){

    }

    @Test
    @DisabledForJreRange(min = JRE.JAVA_8, max = JRE.JAVA_16)
    public void testDisabledForJava8To16(){

    }


    @Test
    @EnabledIfSystemProperties({
            @EnabledIfSystemProperty(named = "java.vendor", matches = "Oracle Corporation")
    })
    void testEnabledOnJavaVendorOracle(){

    }

    @Test
    @DisabledIfSystemProperties({
            @DisabledIfSystemProperty(named = "java.vendor", matches = "Oracle Corporation")
    })
    void testDisabledOnJavaVendorOracle(){

    }

    @Test
    @EnabledIfEnvironmentVariables({
        @EnabledIfEnvironmentVariable(named = "PROFILE", matches = "DEV")
    })
    void testEnabledOnProfileDev(){

    }

    @Test
    @DisabledIfEnvironmentVariables({
            @DisabledIfEnvironmentVariable(named = "PROFILE", matches = "DEV")
    })
    void testDisabledOnProfileDev(){

    }
}
