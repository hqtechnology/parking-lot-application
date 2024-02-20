package com.h12.parking_lot.dao;

import com.h12.parking_lot.model.auth.LoginForm;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Set;

@Repository
public class LoginDto {
    private Set<LoginForm> loginForms;

    public LoginDto() {
        loginForms = new HashSet<>();
    }


    public void create(LoginForm loginForm) {
        loginForms.add(loginForm);
    }

    public boolean isHaving(LoginForm loginForm) {
        return loginForms.contains(loginForm);
    }

    public Set<LoginForm> getLoginForms() {
        return loginForms;
    }
}
