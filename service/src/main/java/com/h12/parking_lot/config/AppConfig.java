package com.h12.parking_lot.config;

import com.h12.parking_lot.model.jwt.JwtKeys;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import java.util.Map;

@Configuration
public class AppConfig {
    private final Logger LOGGER = LoggerFactory.getLogger(getClass());

    @Bean
    public AccessLog accessLog() {
        return new AccessLog();
    }

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    @EventListener
    public void handleContextRefresh(ContextRefreshedEvent event) {
        ApplicationContext applicationContext = event.getApplicationContext();
        RequestMappingHandlerMapping requestMappingHandlerMapping = applicationContext
                .getBean("requestMappingHandlerMapping", RequestMappingHandlerMapping.class);
        Map<RequestMappingInfo, HandlerMethod> map = requestMappingHandlerMapping
                .getHandlerMethods();
        map.forEach((key, value) -> LOGGER.info("Mapping: {} {}", key, value));
    }

    @Bean
    public JwtKeys createKeys() {
        return new JwtKeys();
    }
}
