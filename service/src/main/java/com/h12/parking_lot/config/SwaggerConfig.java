package com.h12.parking_lot.config;

import org.springdoc.core.properties.SpringDocConfigProperties;
import org.springdoc.core.properties.SwaggerUiConfigParameters;
import org.springdoc.core.properties.SwaggerUiConfigProperties;
import org.springdoc.webmvc.ui.SwaggerWelcomeActuator;
import org.springdoc.webmvc.ui.SwaggerWelcomeCommon;
import org.springframework.boot.actuate.autoconfigure.endpoint.web.WebEndpointProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
//@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public SwaggerWelcomeCommon getSwaggerBean(WebEndpointProperties webEndpointProperties) {
        SwaggerUiConfigProperties swaggerUiConfigProperties = new SwaggerUiConfigProperties();
        return new SwaggerWelcomeActuator(swaggerUiConfigProperties,
                new SpringDocConfigProperties(),
                new SwaggerUiConfigParameters(swaggerUiConfigProperties), webEndpointProperties);
    }
}
