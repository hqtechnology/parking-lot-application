package com.h12.parking_lot.model.user;

import lombok.Data;

@Data
public class UserDto {
    private Long id;
    public String firstname;
    public String lastname;
    public String phone;
}
