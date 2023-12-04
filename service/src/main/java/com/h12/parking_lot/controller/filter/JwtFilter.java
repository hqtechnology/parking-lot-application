package com.h12.parking_lot.controller.filter;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JwtFilter implements Filter {
    private static final Logger LOG = LoggerFactory.getLogger(JwtFilter.class);
    private static final List<String> allowedPaths = List.of("swagger/*");
    @Value("${jwt.secret}")
    private String jwtSecret;

    public JwtFilter() {
        super();
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;
        String url = httpServletRequest.getRequestURL().toString();
        LOG.info("url: {}", url);
//        String header = httpServletRequest.getHeader(HttpHeaders.AUTHORIZATION);
//        if (header != null && header.startsWith("Bearer ")) {
//            String token = header.replace("Bearer ", "");
//            Authentication authentication = getAuthentication(token);
//            SecurityContextHolder.getContext().setAuthentication(authentication);
//        }
        chain.doFilter(request, response);
    }


    private Authentication getAuthentication(String token) {
        JwtParser jwtParser = Jwts.parser().build();
        Claims claims = jwtParser.parseEncryptedClaims(token).getPayload();

        String username = claims.getSubject();
        List<GrantedAuthority> authorities = new ArrayList<>();

        return new UsernamePasswordAuthenticationToken(username, null, authorities);
    }
}
