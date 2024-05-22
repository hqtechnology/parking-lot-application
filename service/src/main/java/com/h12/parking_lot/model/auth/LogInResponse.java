package com.h12.parking_lot.model.auth;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class LogInResponse {
    private String token;
    @JsonProperty("expires_in")
    private long expiresIn;
}
