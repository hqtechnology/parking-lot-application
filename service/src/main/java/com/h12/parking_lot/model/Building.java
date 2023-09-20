package com.h12.parking_lot.model;

import org.springframework.web.bind.annotation.ModelAttribute;

import javax.persistence.Id;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Building {
    @Id
    private final String id;
    private final List<Floor> floors;

    public Building() {
        this(1, UUID.randomUUID().toString());
    }

    public Building(int floorCount, String id) {
        this.floors = new ArrayList<>(1);
        this.id = id;
    }

    public List<Floor> getFloors() {
        return floors;
    }

    public void putFloor(int index, Floor floor) {
        floors.add(index, floor);
    }
}
