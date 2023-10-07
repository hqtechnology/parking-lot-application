package com.h12.parking_lot.model.user;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "user")
public class User {
    public String name;
    public String phone;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
}
