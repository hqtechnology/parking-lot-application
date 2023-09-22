package com.h12.parking_lot.service;

import com.h12.parking_lot.dao.FloorRepository;
import com.h12.parking_lot.model.Floor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FloorService {
    private final FloorRepository floorRepository;

    @Autowired
    public FloorService(FloorRepository floorRepository) {
        this.floorRepository = floorRepository;
    }

    public Floor getById(String id) {
        return floorRepository.getReferenceById(id);
    }

    public void save(Floor floor) {
        floorRepository.save(floor);
    }

    public void updateName(Floor floor) {
//        floorRepository.updateName(floor.getName(), floor.getId());
    }

    public void update(Floor floor) {
//        floorRepository.updateNameAndAddress(floor.getName(), floor.getAddress(), floor.getId());
    }

    public void delete(Floor floor) {
        floorRepository.delete(floor);
    }

    public void deleteById(String id) {
        floorRepository.deleteById(id);
    }
}
