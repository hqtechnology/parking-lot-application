package com.h12.parking_lot.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "floors", uniqueConstraints = {
        @UniqueConstraint(columnNames = {
                "id"
        })
})
@Data
public class Floor {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    public int floorCapacity;
    public int floorNumber;

    @OneToMany(fetch = FetchType.EAGER)
    private List<ParkingSlot> parkingSlots;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "building.id")
    private Building building;

    public Floor() {
    }

    public Floor(Integer id, int floorCapacity, int floorNumber, List<ParkingSlot> parkingSlots, Building building) {
        this.id = id;
        this.floorCapacity = floorCapacity;
        this.floorNumber = floorNumber;
        this.parkingSlots = parkingSlots;
        this.building = building;
    }

    public Floor(Integer id, int floorCapacity, int floorNumber, Building building) {
        this.id = id;
        this.floorCapacity = floorCapacity;
        this.floorNumber = floorNumber;
        this.building = building;
    }
}
