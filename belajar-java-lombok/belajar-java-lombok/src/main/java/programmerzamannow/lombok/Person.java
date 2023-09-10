package programmerzamannow.lombok;

import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Person {

    private String id;

    private String name;

    private Integer ages;

    @Singular
    private List<String> hobbies;
}
