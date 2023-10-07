package com.h12.parking_lot.controller;

import com.h12.parking_lot.model.dto.UserDto;
import com.h12.parking_lot.model.user.User;
import com.h12.parking_lot.service.UserService;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    protected static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);
    @Autowired
    protected ModelMapper pojoMapper;
    @Autowired
    private UserService userService;

    // POST: http://localhost:8080/users
    // Content-Type: application/json
    // Payload: { "firstname": "Harish", "lastname": "Maddy" }
    @RequestMapping(value = "", method = RequestMethod.POST)
    public User createUser(@RequestBody User user) {
        LOGGER.debug("Received request to create the {}", user);
        return userService.save(user);
    }

    // GET: http://localhost:8080/users
    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<UserDto> getUsers() {
        LOGGER.debug("Received request to list all users");
        List<User> users = new ArrayList<User>();
        users = (List<User>) userService.findAll();
        // convert User to UserDto
        List<UserDto> usersResponse = new ArrayList<UserDto>();
        for (User user : users) {
            usersResponse.add(pojoMapper.map(user, UserDto.class));
        }
        return usersResponse;
    }

    // GET: http://localhost:8080/users/1
    @RequestMapping(value = "/{userId}", method = RequestMethod.GET)
    public User getUser(@PathVariable long userId) {
        return userService.findOne(userId);
    }

    // GET: http://localhost:8080/users/search?firstname=be
    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public List<User> findUsers(@RequestParam String firstname) {
        Assert.isTrue(!firstname.isEmpty(), "firstname parameter must be present");
        return userService.findByFirstnameStartingWith(firstname);
    }

    // PUT: http://localhost:8080/users/1
    // Content-Type: application/json
    // Payload: { "firstname": "Modified", "lastname": "Name" }
    @RequestMapping(value = "/{userId}", method = RequestMethod.PUT)
    public User updateUser(@PathVariable long userId, @RequestBody User user) {
        user.setId(userId);
        return userService.update(user);
    }

    // DELETE: http://localhost:8080/users/1
    @RequestMapping(value = "/{userId}", method = RequestMethod.DELETE)
    public String deleteUser(@PathVariable long userId) {
        userService.delete(userId);
        return userId + " is Deleted";
    }

}