package programmerzamannow.mengulang.component;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductRepository {

    @Autowired
    @Getter
    private ProductDatabase productDatabase;

}
