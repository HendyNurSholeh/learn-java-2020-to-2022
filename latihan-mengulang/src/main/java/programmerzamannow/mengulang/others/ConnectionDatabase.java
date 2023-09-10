package programmerzamannow.mengulang.others;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

@Slf4j
public class ConnectionDatabase implements InitializingBean, DisposableBean {

    @Override
    public void afterPropertiesSet() throws Exception {
       log.info("Connection Ready too be Use");
    }

    @Override
    public void destroy() throws Exception {
        log.info("Connection close");
    }
}
