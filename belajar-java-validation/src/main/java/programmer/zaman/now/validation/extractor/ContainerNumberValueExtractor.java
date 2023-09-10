package programmer.zaman.now.validation.extractor;

import jakarta.validation.valueextraction.ExtractedValue;
import jakarta.validation.valueextraction.UnwrapByDefault;
import jakarta.validation.valueextraction.ValueExtractor;
import programmer.zaman.now.validation.container.ContainerNumber;

@UnwrapByDefault
public class ContainerNumberValueExtractor implements ValueExtractor<@ExtractedValue(type = Integer.class) ContainerNumber> {

    @Override
    public void extractValues(@ExtractedValue(type = Integer.class) ContainerNumber containerNumber, ValueReceiver valueReceiver) {
        valueReceiver.value(null, containerNumber.getData());
    }
}
