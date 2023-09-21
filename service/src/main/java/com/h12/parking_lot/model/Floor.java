package com.h12.parking_lot.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "floor")
@Data
public class Floor {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private String id;
    private String buildingId;
    private int floorCapacity;
    private int floorNumber;

}
