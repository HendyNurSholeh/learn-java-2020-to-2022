package programmerzamannow.lombok;

import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.Value;
import lombok.With;

@Value
public class Register {

    @With
    private String userName;

    private String password;
}
