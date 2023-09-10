package programmer.zaman.now;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

public class MockitoTest {


    @Test
    void test1() {
        List<String> list = Mockito.mock(List.class);

        Mockito.when(list.get(0)).thenReturn("Eko");

        assertEquals("Eko", list.get(0));

        Mockito.verify(list, Mockito.times(1)).get(0);

    }
}
