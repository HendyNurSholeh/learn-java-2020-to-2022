package programmer.zaman.now.validation;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import programmer.zaman.now.validation.container.Container;

public class DataMahasiswa {

    @NotNull(message = "data must be not null")
    private Container<
            @NotBlank(message = "value must be not blank")
            @Size(min = 1, max = 10, message = "value character must between 1 and 10 ") String
            > data;

    public Container<String> getData() {
        return data;
    }

    public void setData(Container<String> data) {
        this.data = data;
    }
}
