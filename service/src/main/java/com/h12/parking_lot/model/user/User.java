package com.h12.parking_lot.model.user;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    public String firstname;
    public String lastname;
    public String phone;

}
