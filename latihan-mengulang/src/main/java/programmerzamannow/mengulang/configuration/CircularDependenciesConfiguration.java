package programmerzamannow.mengulang.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import programmerzamannow.mengulang.data.CircularA;
import programmerzamannow.mengulang.data.CircularB;
import programmerzamannow.mengulang.data.CircularC;

@Configuration
public class CircularDependenciesConfiguration {

//    @Bean
//    public CircularA circularA(CircularB circularB){
//        return new CircularA(circularB);
//    }
//
//    @Bean
//    public CircularB circularB(CircularC circularC){
//        return new CircularB(circularC);
//    }
//
//    @Bean
//    public CircularC circularC(CircularA circularA){
//        return new CircularC(circularA);
//    }
}
