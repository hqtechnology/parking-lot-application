package com.h12.parking_lot.controller.filter;

import com.h12.parking_lot.service.JwtService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

//@Component
//@Order(1)
public class JwtAuthFilter extends OncePerRequestFilter {
    private final JwtKeyUtil jwtkeyUtil;

    @Autowired
    public JwtTokenFilter(JwtKeyUtil jwtkeyUtil) {
        this.jwtkeyUtil = jwtkeyUtil;
    }

    @SneakyThrows
    @Override
    public void doFilterInternal(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        String token = jwtkeyUtil.resolveToken((HttpServletRequest) req);
        if (token != null && jwtkeyUtil.validateToken(token)) {
            UsernamePasswordAuthenticationToken auth = jwtkeyUtil.authenticateUser(token);
            auth.setDetails(new WebAuthenticationDetailsSource().buildDetails(req));
            SecurityContextHolder.getContext().setAuthentication(auth);
        }
        chain.doFilter(req, res);
    }
}
