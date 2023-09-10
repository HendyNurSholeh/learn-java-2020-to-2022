package programmerzamannow.mengulang.component;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Getter
public class ProductService {

    private ProductRepository productRepository;

    private ProductDatabase productDatabase;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Autowired
    public ProductService(ProductRepository productRepository, ProductDatabase productDatabase) {
        this.productRepository = productRepository;
        this.productDatabase = productDatabase;
    }
}
