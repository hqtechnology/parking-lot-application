package com.h12.parking_lot.model.vehicle;

import com.h12.parking_lot.model.parking.ParkingSlot;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "vehicle", uniqueConstraints = {
        @UniqueConstraint(columnNames = {
                "id"
        })
})
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "ID")
    private Integer id;
    public VehicleType type;
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "vehicle")
    private ParkingSlot parkingSlot;

    public Vehicle() {
    }

    public Vehicle(Integer id, VehicleType type, ParkingSlot parkingSlot) {
        this.id = id;
        this.type = type;
        this.parkingSlot = parkingSlot;
    }
    //    public Vehicle(Integer id, VehicleType type, ParkingSlot parkingSlot) {
//        this.id = id;
//        this.type = type;
//        this.parkingSlot = parkingSlot;
//    }

//    public Vehicle(Integer id, VehicleType type) {
//        this.id = id;
//        this.type = type;
//    }
}
