package com.h12.parking_lot.service;

import com.h12.parking_lot.dao.ParkingRepository;
import com.h12.parking_lot.model.Building;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ParkingService {
    private final ParkingRepository parkingLotDAO;

    @Autowired
    public ParkingService(ParkingRepository parkingLotDAO) {
        this.parkingLotDAO = parkingLotDAO;
    }

    public void addBuilding(Building building) {
        parkingLotDAO.save(building);
    }
}
