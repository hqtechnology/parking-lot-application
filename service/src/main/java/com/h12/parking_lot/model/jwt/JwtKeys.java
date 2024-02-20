package com.h12.parking_lot.model.jwt;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;

@Data
public class JwtKeys {
    @Value("${login.jwt.privateKey}")
    private String privateKey;

    @Value("${login.jwt.publicKey}")
    private String publicKey;
}
