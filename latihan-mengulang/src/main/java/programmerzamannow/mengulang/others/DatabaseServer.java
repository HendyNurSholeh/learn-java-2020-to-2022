package programmerzamannow.mengulang.others;

import lombok.extern.slf4j.Slf4j;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Slf4j
public class DatabaseServer {

    @PostConstruct
    public void start(){
        log.info("Start database");
    }

    @PreDestroy
    public void stop(){
        log.info("Stop database");
    }
}
