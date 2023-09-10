package programmerzamannow.mengulang.component;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import programmerzamannow.mengulang.data.MerchantService;

@Component
@Slf4j
public class MerchantServiceImpl implements MerchantService {

    @Override
    public void service() {
        log.info("service configuration");
    }
}
