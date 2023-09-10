package programmerzamannow.lombok;

import lombok.*;

@Getter
@Setter
@RequiredArgsConstructor
@NoArgsConstructor
public class Member {

    @NonNull
    private String id;

    @NonNull
    private String name;

    public void sayHello(@NonNull String name){
        System.out.println("hello brooo " + name + ", wkwkwk");
    }
}
