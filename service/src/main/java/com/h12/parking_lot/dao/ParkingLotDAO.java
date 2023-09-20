package com.h12.parking_lot.dao;

import com.h12.parking_lot.model.Building;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
//@Repository
public class ParkingLotDAO {
    private static int NO_OF_BUILDINGS = 1;
    private static Map<String, Building> buildings;

    public ParkingLotDAO() {
        this(1);
    }

    public ParkingLotDAO(int size) {
        ParkingLotDAO.NO_OF_BUILDINGS = size;
        ParkingLotDAO.buildings = new HashMap<>(size + 1);
    }

    public Building getBuilding(String buildingNumber) {
        return buildings.get(buildingNumber);
    }
}
