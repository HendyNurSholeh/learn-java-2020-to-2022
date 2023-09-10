package programmer.zaman.now.validation.extractor;

import jakarta.validation.valueextraction.ExtractedValue;
import jakarta.validation.valueextraction.ValueExtractor;
import programmer.zaman.now.validation.container.KeyValueContainer;

public class KeyValueContainerEtractorKey implements ValueExtractor<KeyValueContainer<@ExtractedValue ?, ?>> {

    @Override
    public void extractValues(KeyValueContainer<?, ?> keyValueContainer, ValueReceiver valueReceiver) {
        valueReceiver.indexedValue(null, 1, keyValueContainer.getKey());
    }
}
