package programmerzamannow.mengulang.component;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import programmerzamannow.mengulang.data.IdAware;

import java.util.UUID;

@Component
@Slf4j
public class IdGeneratorBeanPostProcessorSecond implements BeanPostProcessor, Ordered {

    @Override
    public int getOrder() {
        return 2;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof IdAware){
            String uuid = UUID.randomUUID().toString();
            ((IdAware) bean).setId(uuid);
        }
        return bean;
    }
}
