package programmerzamannow.mengulang.component;

import lombok.Getter;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@Getter
public class Person {

    private Address address;

    private Age age;

    public Person(Optional<Address> address, Optional<Age> age) {
        this.address = address.orElse(null);
        this.age = age.orElse(null);
    }
}
