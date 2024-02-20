package com.h12.parking_lot.config;

import com.h12.parking_lot.controller.filter.BasicAuthFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;


@Configuration
@EnableWebSecurity
public class SecurityConfig {
    private static final Logger LOGGER = LoggerFactory.getLogger(SecurityConfig.class);

//    @Bean
//    public WebSecurityCustomizer webSecurityCustomizer() {
//        return (web) -> web.ignoring()
//                .requestMatchers("**/resources/**", "/index.html", "/swagger/**", "**/api-docs", "/static/**");
//    }

    @Bean
    @Order
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(AbstractHttpConfigurer::disable)
//                .authorizeHttpRequests((auth) -> {
//                    auth.requestMatchers("**/resources/**", "**/index.html", "**/swagger**", "/swagger**","**/api-docs**", "**/static/**").permitAll();
//                })
                .authorizeHttpRequests((auth) -> auth.anyRequest().permitAll())
//                .addFilterBefore(new JwtFilter(), BeforeJwtFilter.class);
                .addFilterAfter(new BasicAuthFilter(), BasicAuthenticationFilter.class);

        //http.addFilterBefore(new JwtFilter(), UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }

    private <T> T getContext(HttpSecurity http, Class<T> clazz) {
        return http.getSharedObject(clazz);
    }

}

