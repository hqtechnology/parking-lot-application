package com.h12.parking_lot.service;

import com.h12.parking_lot.dao.ParkingRepository;
import com.h12.parking_lot.model.ParkingSlot;
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

    public ParkingSlot getById(Integer id) {
        return parkingLotDAO.findById(id).get();
    }

    public void save(ParkingSlot parkingSlot) {
        parkingLotDAO.save(parkingSlot);
    }

    public int update(ParkingSlot parkingSlot) {
        ParkingSlot parkingSlot1 = parkingLotDAO.findById(parkingSlot.getId()).get();
        parkingSlot1.slotNumber = parkingSlot.slotNumber;
        parkingSlot1.isOccupied = parkingSlot.isOccupied;
        parkingSlot1.setVehicle(parkingSlot.getVehicle());
        parkingSlot1.setFloor(parkingSlot.getFloor());
        parkingLotDAO.save(parkingSlot1);
        return 1;
    }

    public List<ParkingSlot> getAll() {
        return parkingLotDAO.findAll();
    }

    public void delete(ParkingSlot parkingSlot) {
        parkingLotDAO.delete(parkingSlot);
    }

    public void deleteById(Integer id) {
        parkingLotDAO.deleteById(id);
    }
}
