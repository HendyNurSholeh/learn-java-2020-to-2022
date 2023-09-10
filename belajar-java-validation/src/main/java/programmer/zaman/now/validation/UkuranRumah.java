package programmer.zaman.now.validation;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import programmer.zaman.now.validation.container.ContainerNumber;

public class UkuranRumah {

    @Min(2)
    private ContainerNumber ukuran;

    @NotBlank
    private String nameRumah;

    public UkuranRumah() {
    }

    public UkuranRumah(ContainerNumber ukuran, String nameRumah) {
        this.ukuran = ukuran;
        this.nameRumah = nameRumah;
    }

    public ContainerNumber getUkuran() {
        return ukuran;
    }

    public void setUkuran(ContainerNumber ukuran) {
        this.ukuran = ukuran;
    }

    public String getNameRumah() {
        return nameRumah;
    }

    public void setNameRumah(String nameRumah) {
        this.nameRumah = nameRumah;
    }
}
