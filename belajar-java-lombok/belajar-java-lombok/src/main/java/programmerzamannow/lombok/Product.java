package programmerzamannow.lombok;

import lombok.*;

@RequiredArgsConstructor(staticName = "hehehe")
@Data
@AllArgsConstructor
public class Product {

    private final String id;

    private String name;

    private String price;
}
