package programmerzamannow.mengulang.component;

import lombok.Getter;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Component;
import org.w3c.dom.stylesheets.LinkStyle;
import programmerzamannow.mengulang.data.Foo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
@Getter
public class MultiFoo {

    List<Foo> foos;

    public MultiFoo(ObjectProvider<Foo> objectProvider) {
        this.foos = objectProvider.stream().collect(Collectors.toList());
    }
}
