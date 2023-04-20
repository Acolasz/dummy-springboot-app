package hu.kukutyin.dummy.service.app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import hu.kukutyin.dummy.service.app.aop.logging.LoggingAspect;

@Configuration
public class AspectConfig {

    @Bean
    public LoggingAspect loggingAspect(){
        return new LoggingAspect();
    }
}
