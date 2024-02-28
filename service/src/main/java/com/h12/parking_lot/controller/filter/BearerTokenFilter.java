package com.h12.parking_lot.controller.filter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.web.filter.GenericFilterBean;

import java.io.IOException;

public class BearerTokenFilter extends GenericFilterBean {
    public static final Logger log = LoggerFactory.getLogger(BearerTokenFilter.class);

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;
        String url = httpServletRequest.getRequestURL().toString();
        log.info("BearerTokenFilter url: {}", url);
        String header = httpServletRequest.getHeader(HttpHeaders.AUTHORIZATION);
        if (bearerTokenCheck(header)) {
            httpServletResponse.setStatus(401);
        } else {
            chain.doFilter(request, response);
        }
    }

    private boolean bearerTokenCheck(String header) {
        if (header == null) {
            return false;
        }
        String[] parts = header.split(" ");

        return parts[0].equalsIgnoreCase("bearer");
    }

}
