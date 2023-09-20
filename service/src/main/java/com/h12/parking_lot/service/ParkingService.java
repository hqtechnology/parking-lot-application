package com.h12.parking_lot.service;

import com.h12.parking_lot.dao.ParkingLotDAO;
import com.h12.parking_lot.dao.ParkingRepository;
import com.h12.parking_lot.model.Building;
import com.h12.parking_lot.model.Floor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParkingService {
    private final ParkingRepository parkingLotDAO;

    @Autowired
    public ParkingService(ParkingRepository parkingLotDAO) {
        this.parkingLotDAO = parkingLotDAO;
    }

    public List<Floor> getFreeSlots(int buildingNumber) {
        Building building = parkingLotDAO.getReferenceById(buildingNumber);
        List<Floor> currentBuildingFloors = building.getFloors();
        //TODO: find free floors.
        return currentBuildingFloors;
    }

    public void addBuilding(Building building) {
        parkingLotDAO.save(building);
    }
}
