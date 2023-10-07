package com.h12.parking_lot.model.building;

import com.h12.parking_lot.model.floor.Floor;
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
    @NotNull
    public String name;
    public String address;
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "ID")
    private String buildingId;
    @OneToMany(targetEntity = Floor.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "BUILDING_ID")
    private List<Floor> floors;

    public Building() {
    }

//    public Building(String buildingId, String name, String address, List<Floor> floors) {
//        this.buildingId = buildingId;
//        this.name = name;
//        this.address = address;
//        this.floors = floors;
//    }
//
//    public Building(String buildingId, String name, String address) {
//        this.buildingId = buildingId;
//        this.name = name;
//        this.address = address;
//    }
}
