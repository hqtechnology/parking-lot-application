package com.h12.parking_lot.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import java.security.GeneralSecurityException;
import java.util.*;

@Component
public class JwtKeyUtil {

    public String resolveToken(HttpServletRequest req) {
        String bearerToken = req.getHeader("Authorization");
        if (bearerToken != null && bearerToken.startsWith("Bearer ")) {
            return bearerToken.substring(7, bearerToken.length());
        }
        return null;
    }

    public UsernamePasswordAuthenticationToken authenticateUser(String token) throws GeneralSecurityException {

        Claims claims = Jwts.parser().build().parseUnsecuredClaims(token).getPayload();
        Set<SimpleGrantedAuthority> grantedValues = getGrantedValues(claims);
        SecurityProperties.User principal = new SecurityProperties.User();
        principal.setName(claims.getSubject());
//        principal.setRoles(grantedValues);

        return new UsernamePasswordAuthenticationToken(principal, "", grantedValues);
    }

    private Set<SimpleGrantedAuthority> getGrantedValues(Claims claims) {
        Set<SimpleGrantedAuthority> authorities = new HashSet<>();
        try {
            String scopes = claims.get("scopes").toString();
            String scopesAsList = scopes.substring(scopes.indexOf("[") + 1, scopes.indexOf("]"));
            if (!scopesAsList.isEmpty()) {
                List<String> fullList = Arrays.asList(scopesAsList.split(","));
                if (fullList.contains("admin")) { // If admin scope allow ADMIN ROLES
                    authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
                } else {
                    authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
                }
            }
        } catch (Exception e) {

        }
        return authorities;
    }

    public boolean validateToken(String token) {
        try {
            Jws<Claims> claims = Jwts.parser().build().parseClaimsJws(token);
            return !claims.getBody().getExpiration().before(new Date());
        } catch (Exception e) {
            return false;
        }
    }

    public void priorityQ() {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

    }
}
