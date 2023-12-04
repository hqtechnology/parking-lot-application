package com.h12.parking_lot.dao;

import com.h12.parking_lot.model.user.User;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


public interface UserRepository extends JpaRepository<User, Long> {

    List<User> findByLastname(String lastname);

    @Query(value = "SELECT u FROM User u WHERE UPPER(u.firstname) LIKE ?1%")
    List<User> findByFirstnameStartingWithIgnoreCase(String firstname, Sort sort);

    @Query(value = "SELECT COUNT(*) FROM User u WHERE u.firstname = :firstname", nativeQuery = true)
    Long countUsersByFirstname(@Param("firstname") String firstname);
}
