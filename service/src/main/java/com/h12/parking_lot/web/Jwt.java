package com.h12.parking_lot.web;


import com.h12.parking_lot.web.exception.InvalidTokenException;

import java.util.Base64;

public class Jwt {
    private final String token;
    private final long expiresIn;
    private long exp;

    public Jwt(String token, long expiresIn) {
        this.token = token;
        this.expiresIn = expiresIn;
        init();
    }

    private void init() {
        String parts[] = token.split("\\.");
        if (parts.length != 3) {
            throw new InvalidTokenException("Invalid JWT token received.");
        }
        Base64.getDecoder().decode(parts[1]);
    }
}
