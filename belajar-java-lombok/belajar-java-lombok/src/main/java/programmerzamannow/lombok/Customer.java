package programmerzamannow.lombok;

import lombok.*;

@AllArgsConstructor(staticName = "create")
@NoArgsConstructor(staticName = "createEmpty")
@Getter
@Setter
@EqualsAndHashCode(exclude = "id")
public class Customer {

    private String id;

    private String name;

}
