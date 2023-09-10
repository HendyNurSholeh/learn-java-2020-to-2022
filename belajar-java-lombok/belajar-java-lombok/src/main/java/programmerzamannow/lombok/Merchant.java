package programmerzamannow.lombok;

import lombok.*;

@RequiredArgsConstructor
@Setter
@Getter
public class Merchant {

    private final String id;

    private final String name;
}
