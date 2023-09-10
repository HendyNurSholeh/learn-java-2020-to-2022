package programmer.zaman.now.validation.extractor;

import jakarta.validation.valueextraction.ExtractedValue;
import jakarta.validation.valueextraction.ValueExtractor;
import programmer.zaman.now.validation.container.Container;

public class ContainerExtractor implements ValueExtractor<Container<@ExtractedValue ?>> {

    @Override
    public void extractValues(Container<?> container, ValueReceiver valueReceiver) {
        valueReceiver.value(null, container.getData());
    }
}
