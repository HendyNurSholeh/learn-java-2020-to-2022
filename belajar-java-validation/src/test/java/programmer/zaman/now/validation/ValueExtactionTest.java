package programmer.zaman.now.validation;

import org.junit.jupiter.api.Test;
import programmer.zaman.now.validation.container.Container;
import programmer.zaman.now.validation.container.ContainerNumber;
import programmer.zaman.now.validation.container.KeyValueContainer;

public class ValueExtactionTest extends AbstractValidator{

    @Test
    void testMemakaiContainerDariLuar() {
        var dataMahasiswa = new DataMahasiswa();
        dataMahasiswa.setData(new Container<>());
        dataMahasiswa.getData().setData("    ");
        validate(dataMahasiswa);
    }

    @Test
    void testContainerMultipleGenericType() {
        var dataMotor = new DataMontor();
        dataMotor.setData(new KeyValueContainer<>());
        dataMotor.getData().setValue("   ");
        dataMotor.getData().setKey("   ");
        validate(dataMotor);
    }

    @Test
    void testContainerNonGenericType() {
        var dataRumah = new UkuranRumah(new ContainerNumber(), "mantap");
        dataRumah.getUkuran().setData(1);
        dataRumah.getUkuran().setData(1);
        dataRumah.getUkuran().setData(1);
        dataRumah.getUkuran().setData(2);
        validate(dataRumah);
    }
}
