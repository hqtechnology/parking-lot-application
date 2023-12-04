package com.h12.parking_lot.model.auth;

import lombok.Data;

@Data
public class LogOutResponse {
    private String userId;
    private boolean isLoggedOut;
}
