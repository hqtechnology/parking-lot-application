package com.h12.parking_lot.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "user", uniqueConstraints = {
        @UniqueConstraint(columnNames = {
                "id"
        })
})
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    public String name;
    public String phone;
}
