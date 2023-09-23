package com.h12.parking_lot.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "parking_slot", uniqueConstraints = {
        @UniqueConstraint(columnNames = {
                "id"
        })
})
public class ParkingSlot {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    public int slotNumber;
    public boolean isOccupied;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "floor.id")
    private Floor floor;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "vehicle.id")
    private Vehicle vehicle;

    public ParkingSlot() {
    }

    public ParkingSlot(Integer id, int slotNumber, boolean isOccupied, Floor floor, Vehicle vehicle) {
        this.id = id;
        this.slotNumber = slotNumber;
        this.isOccupied = isOccupied;
        this.floor = floor;
        this.vehicle = vehicle;
    }

    public ParkingSlot(Integer id, int slotNumber, boolean isOccupied, Floor floor) {
        this.id = id;
        this.slotNumber = slotNumber;
        this.isOccupied = isOccupied;
        this.floor = floor;
    }

    public ParkingSlot(Integer id, int slotNumber, boolean isOccupied, Vehicle vehicle) {
        this.id = id;
        this.slotNumber = slotNumber;
        this.isOccupied = isOccupied;
        this.vehicle = vehicle;
    }
}
