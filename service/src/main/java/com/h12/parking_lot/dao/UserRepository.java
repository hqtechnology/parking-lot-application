package com.h12.parking_lot.dao;

import com.h12.parking_lot.model.user.User;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface UserRepository extends JpaRepository<User, Long> {

    // No need to put query annotation if method name follows naming rule.
    // For details, check Spring Data JPA documentation
    List<User> findByLastname(String lastname);

    @Query("SELECT u FROM User u WHERE UPPER(u.firstname) LIKE ?1%")
        // case insensitive
    List<User> findByFirstnameStartingWithIgnoreCase(String firstname, Sort sort);

    @Query("SELECT COUNT(u) FROM User u WHERE u.firstname = ?1")
    Integer countByFirstname(String firstname);
}
