package com.h12.parking_lot.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.h12.parking_lot.model.jwt.JwtKeys;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwt;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Component
public class JwtService {
    public static final String SECRET = "5367566B59703373367639792F423F4528482B4D6251655468576D5A71347437";
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private JwtKeys jwtKeys;

    public String generateToken(String userName) {
        Map<String, Object> claims = new HashMap<>();
        return createToken(claims, userName);
    }

    private String createToken(Map<String, Object> claims, String userName) {
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(userName)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setIssuer("parking_lot")
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 30))
                .claim("scope", "read write")
                .signWith(getSignKey(), SignatureAlgorithm.HS256).compact();
    }

    private Key getSignKey() {
        byte[] keyBytes = Decoders.BASE64.decode(jwtKeys.getPrivateKey().strip().replace("\n", ""));
        return Keys.hmacShaKeyFor(keyBytes);
    }

    public String extractUsername(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    public Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }

    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    private Claims extractAllClaims(String token) {
        try {
            String[] parts = token.split("\\.");
            String payload = parts[0];
            String payloadJson = new String(Base64.getDecoder().decode(payload.getBytes(StandardCharsets.UTF_8)));
            HashMap<String, String> payloadMap = objectMapper.readValue(payloadJson, HashMap.class);
            Claims claims = Jwts.claims().build();
            claims.putAll(payloadMap);
            Jwt<?, HashMap<String, String>> jwt = (Jwt<?, HashMap<String, String>>) Jwts.parser().build().parse(token);
            jwt.getPayload();
            return claims;
        } catch (JsonProcessingException e) {
            return null;
        }
    }

    private Boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    public Boolean validateToken(String token) {
        return !isTokenExpired(token);
    }


}

