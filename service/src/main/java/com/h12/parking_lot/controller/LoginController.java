package com.h12.parking_lot.controller;

import com.h12.parking_lot.model.auth.LogOutForm;
import com.h12.parking_lot.model.auth.LogOutResponse;
import com.h12.parking_lot.model.auth.LoginForm;
import com.h12.parking_lot.model.auth.LogInResponse;
import com.h12.parking_lot.response.model.Response;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController()
public class LoginController {
    @Autowired
    private ModelMapper modelMapper;

    @PostMapping("/login")
    public Response login(@RequestBody LoginForm loginForm) {
        LogInResponse loginResponse = modelMapper.map(loginForm, LogInResponse.class);
        loginResponse.setLoggedIn(true);
        return Response.of(loginResponse);
    }

    @PostMapping("/logout")
    public Response logout(@RequestBody LogOutForm logOutForm) {
        LogOutResponse logOutResponse = modelMapper.map(logOutForm, LogOutResponse.class);
        logOutResponse.setLoggedOut(true);
        return Response.of(logOutResponse);
    }
}
