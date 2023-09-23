package com.h12.parking_lot.config;

import org.springdoc.core.properties.SpringDocConfigProperties;
import org.springdoc.core.properties.SwaggerUiConfigParameters;
import org.springdoc.core.properties.SwaggerUiConfigProperties;
import org.springdoc.webmvc.ui.SwaggerWelcomeActuator;
import org.springdoc.webmvc.ui.SwaggerWelcomeCommon;
import org.springframework.boot.actuate.autoconfigure.endpoint.web.WebEndpointProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
//@EnableSwagger2
public class SwaggerConfig {

//    @Bean
//    public SwaggerWelcomeCommon getSwaggerBean(ApplicationContext applicationContext, WebEndpointProperties webEndpointProperties) {
//        SwaggerUiConfigProperties swaggerUiConfigProperties = new SwaggerUiConfigProperties();
//        swaggerUiConfigProperties.setEnabled(true);
//        SpringDocConfigProperties springDocConfigProperties = new SpringDocConfigProperties();
//        SwaggerUiConfigParameters swaggerUiConfigParameters = new SwaggerUiConfigParameters(swaggerUiConfigProperties);
//        return new SwaggerWelcomeActuator(swaggerUiConfigProperties,
//                springDocConfigProperties,
//                swaggerUiConfigParameters, webEndpointProperties);
//    }
}
