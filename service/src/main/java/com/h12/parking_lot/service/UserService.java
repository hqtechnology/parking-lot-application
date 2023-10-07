package com.h12.parking_lot.service;

import com.h12.parking_lot.model.user.User;

import java.util.List;

public interface UserService {

    User save(User user);

    List<User> findAll();

    User findOne(long userId);

    List<User> findByFirstnameStartingWith(String firstname);

    User update(User user);

    User delete(long user);
}
