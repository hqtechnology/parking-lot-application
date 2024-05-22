package com.h12.parking_lot.model.user;

import lombok.Data;

@Data
public class UserDto {
    public String name;
    public String email;
    public String roles;
    private Long id;
}
