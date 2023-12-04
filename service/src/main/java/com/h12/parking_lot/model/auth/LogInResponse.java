package com.h12.parking_lot.model.auth;

import lombok.Data;

@Data
public class LogInResponse {
    private String username;
    private String userId;
    private boolean isLoggedIn;
}
