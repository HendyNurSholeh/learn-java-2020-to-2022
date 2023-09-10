package programmer.zaman.now.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import programmer.zaman.now.data.Person;
import programmer.zaman.now.repository.Repository;

@ExtendWith(MockitoExtension.class)
public class ServiceTest {

    @Mock
    Repository repository;

    Service service;

    @BeforeEach
    void setUp() {
        service = new Service(repository);
    }

    @Test
    void getPersonNotFound() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            service.get("hdy");
        });

    }

    @Test
    void getPerson() {
        Mockito.when(repository.selectById("ganteng")).thenReturn(new Person("hendy", "ganteng"));

        Person person = service.get("ganteng");

        Assertions.assertNotNull(person);
    }

    @Test
    void createId() {
        Person person = service.createId("Hendy");
        Assertions.assertEquals(person.getName(), "Hendy");
        Assertions.assertNotNull(person.getId());

        Mockito.verify(repository, Mockito.times(1)).insert(person);
    }
}
