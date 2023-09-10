package programmerzamannow.mengulang.component;

import lombok.Getter;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
@Getter
public class AuthService implements ApplicationContextAware, BeanNameAware {

    private String beanName;

    private ApplicationContext applicationContext;

    @Override
    public void setBeanName(String name) {
       this.beanName = name;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
