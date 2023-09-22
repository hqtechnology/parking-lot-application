package com.h12.parking_lot.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "buildings", uniqueConstraints = {
        @UniqueConstraint(columnNames = {
                "id"
        })
})
public class Building {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    private String id;
    @NotNull
    private String name;
    private String address;

    @OneToMany(targetEntity = Floor.class, fetch = FetchType.EAGER)
    private List<Floor> floors;

    public Building() {
    }

    public Building(String id, String name, String address, List<Floor> floors) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.floors = floors;
    }

    public Building(String id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }
}
