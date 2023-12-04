package com.h12.parking_lot.model.auth;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class LogOutForm {
    @JsonProperty("userId")
    private String userId;
}
