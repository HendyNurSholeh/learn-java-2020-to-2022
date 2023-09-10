package programmer.zaman.now.validation;

import jakarta.validation.constraints.NotBlank;
import programmer.zaman.now.validation.container.KeyValueContainer;

public class DataMontor {
    
    private KeyValueContainer<String, String> data;

    public KeyValueContainer<@NotBlank String, @NotBlank String> getData() {
        return data;
    }

    public void setData(KeyValueContainer<String, String> data) {
        this.data = data;
    }
}
