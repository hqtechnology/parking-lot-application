package com.h12.parking_lot.model.parking;

import com.h12.parking_lot.model.vehicle.Vehicle;
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
    public int slotNumber;
    public boolean isOccupied;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "ID")
    private Integer parkingId;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "VEHICLE_ID", referencedColumnName = "id")
    private Vehicle vehicle;

//    @ManyToOne(fetch = FetchType.EAGER)
//    @JoinColumn(name = "floor.id")
//    private Floor floor;

    public ParkingSlot() {
    }

//    public ParkingSlot(Integer parkingId, int slotNumber, boolean isOccupied, Floor floor, Vehicle vehicle) {
//        this.parkingId = parkingId;
//        this.slotNumber = slotNumber;
//        this.isOccupied = isOccupied;
//        this.floor = floor;
//        this.vehicle = vehicle;
//    }
//
//    public ParkingSlot(Integer parkingId, int slotNumber, boolean isOccupied, Floor floor) {
//        this.parkingId = parkingId;
//        this.slotNumber = slotNumber;
//        this.isOccupied = isOccupied;
//        this.floor = floor;
//    }
//
//    public ParkingSlot(Integer parkingId, int slotNumber, boolean isOccupied, Vehicle vehicle) {
//        this.parkingId = parkingId;
//        this.slotNumber = slotNumber;
//        this.isOccupied = isOccupied;
//        this.vehicle = vehicle;
//    }
}
