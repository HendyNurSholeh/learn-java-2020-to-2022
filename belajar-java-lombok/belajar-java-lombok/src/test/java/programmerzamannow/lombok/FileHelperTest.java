package programmerzamannow.lombok;

import org.junit.jupiter.api.Test;

import java.io.IOException;

public class FileHelperTest {

    @Test
    void testCleanUp(){
        String loadFile = FileHelper.loadFile("pom.xml");
        System.out.println("apa aja");
        System.out.println(loadFile);
    }
}
