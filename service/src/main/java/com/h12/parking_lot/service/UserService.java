package com.h12.parking_lot.service;

import com.h12.parking_lot.dao.UserRepository;
import com.h12.parking_lot.exception.AlreadyExistsException;
import com.h12.parking_lot.exception.NotExistsException;
import com.h12.parking_lot.model.user.User;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

@Service
@Validated
public class UserService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserService.class);

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    public User save(@NotNull @Valid final User user) {
        LOGGER.debug("Creating {}", user);
        if (userRepository.existsById(user.getId())) {
            throw new AlreadyExistsException(
                    String.format("There already exists a user with id=%s", user.getId()));
        }
        return userRepository.save(user);
    }

    @Transactional(readOnly = true)
    public List<User> findAll() {
        LOGGER.debug("Retrieving the list of all users");
        return (List<User>) userRepository.findAll();
    }

    @Transactional(readOnly = true)
    public User findOne(long id) {
        LOGGER.debug("Retrieving a user by user id={}", id);
        AtomicReference<User> user = new AtomicReference<>();
        userRepository.findById(id).ifPresent(user::set);
        if (user.get() == null) {
            throw new NotExistsException(
                    String.format("No user exists with id=%d", id));
        }
        return user.get();
    }

    public List<User> findByUsernameStartingWith(String username) {
        LOGGER.debug("Retrieving the list of all users with username start with {}", username);
        return userRepository.findByUsernameStartingWithIgnoreCase(username.toUpperCase(), Sort.by(Sort.Direction.ASC, "username"));
    }

    @Transactional
    public User update(@NotNull @Valid final User user) {
        LOGGER.debug("Updating {}", user);
        AtomicReference<User> existing = new AtomicReference<>();
        userRepository.findById(user.getId()).ifPresent(existing::set);
        if (existing.get() == null) {
            throw new NotExistsException(
                    String.format("No user exists with id=%s", user.getId()));
        }
        return userRepository.save(user);
    }

    @Transactional
    public User delete(@NotNull @Valid final long userId) {
        LOGGER.debug("Deleting {}", userId);
        AtomicReference<User> existing = new AtomicReference<>();
        userRepository.findById(userId).ifPresent(existing::set);
        if (existing.get() == null) {
            throw new NotExistsException(
                    String.format("No user exists with id=%s", userId));
        }
        userRepository.delete(existing.get());
        return existing.get();
    }
}
