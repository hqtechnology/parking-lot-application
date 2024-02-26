package com.h12.parking_lot.config;

import org.springframework.boot.autoconfigure.web.servlet.DispatcherServletAutoConfiguration;
import org.springframework.boot.autoconfigure.web.servlet.DispatcherServletPath;
import org.springframework.boot.autoconfigure.web.servlet.DispatcherServletRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.DispatcherServlet;

@Configuration
public class DispatcherServletCustomConfiguration {

//    @Bean
//    public DispatcherServlet dispatcherServlet() {
//        return new DispatcherServlet();
//    }
//
//    @Bean
//    public DispatcherServletPath dispatcherServletPath(DispatcherServlet dispatcherServlet) {
//        return new DispatcherServletRegistrationBean(dispatcherServlet, "");
//    }
//
//    @Bean
//    public ServletRegistrationBean<?> dispatcherServletRegistration() {
//        ServletRegistrationBean<?> registration = new ServletRegistrationBean<>(dispatcherServlet(), "/api/v1");
//        registration.setName(DispatcherServletAutoConfiguration.DEFAULT_DISPATCHER_SERVLET_REGISTRATION_BEAN_NAME);
//        return registration;
//    }
}
