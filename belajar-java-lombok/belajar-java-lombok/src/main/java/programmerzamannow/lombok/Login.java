package programmerzamannow.lombok;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter(value = AccessLevel.PROTECTED)
@Setter(value = AccessLevel.PROTECTED)
@ToString(exclude = "password")
public class Login {

    private String userName;

    private String password;
}
