package com.h12.parking_lot.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.h12.parking_lot.model.auth.LogInResponse;
import com.h12.parking_lot.model.auth.LogOutForm;
import com.h12.parking_lot.model.auth.LogOutResponse;
import com.h12.parking_lot.model.auth.LoginForm;
import com.h12.parking_lot.model.jwt.JwtKeys;
import com.h12.parking_lot.response.model.Response;
import com.h12.parking_lot.service.JwtService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController()
@Slf4j
public class LoginController {
    //    public static final Logger log = LoggerFactory.getLogger(LoginController.class);
    @Autowired
    private ModelMapper modelMapper;
    @Value("${login.username}")
    private String username;
    @Value("${login.password}")
    private String password;
    @Autowired
    private JwtKeys keys;
    @Autowired
    private JwtService jwtService;

    @Autowired
    private ObjectMapper objectMapper;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody LoginForm loginRequest) throws JsonProcessingException {

        log.debug("LoginRequest: username: {} passcode: ***", loginRequest.getEmail());

        String providedUsername = loginRequest.getEmail();
        String providedPassword = loginRequest.getPassword();

        if (username.equals(providedUsername) && password.equals(providedPassword)) {
            String token = jwtService.generateToken(username);
            LogInResponse logInResponse = new LogInResponse();
            logInResponse.setToken(token);
            logInResponse.setExpiresIn(1800L);
            return ResponseEntity.ok().body(logInResponse);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
        }
    }

    @PostMapping("/logout")
    public Response logout(@RequestBody LogOutForm logOutForm) {
        LogOutResponse logOutResponse = modelMapper.map(logOutForm, LogOutResponse.class);
        logOutResponse.setLoggedOut(true);
        return Response.of(logOutResponse);
    }

    private String generateToken() {
        long currentTimeMillis = System.currentTimeMillis();
        long expirationTimeMillis = currentTimeMillis + 1800000; // 30 min
        Date expirationDate = new Date(expirationTimeMillis);

        return Jwts.builder()
                .expiration(expirationDate)
                .claim("scope", "read write")
                .signWith(SignatureAlgorithm.HS256, keys.getPrivateKey().strip().replace("\n", ""))
                .compact();
    }

    @GetMapping("/jwks.json")
    public ResponseEntity<?> getPublicKey() {
        Map<String, Object> map = new HashMap<>();
        map.put("keys", List.of(keys.getPublicKey()));
        return ResponseEntity.of(Optional.of(map));
    }
}
