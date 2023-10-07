package com.h12.parking_lot.service;

import com.h12.parking_lot.dao.FloorRepository;
import com.h12.parking_lot.model.floor.Floor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FloorService {
    private final FloorRepository floorRepository;

    @Autowired
    public FloorService(FloorRepository floorRepository) {
        this.floorRepository = floorRepository;
    }

    public Floor getById(Integer id) {
        return floorRepository.findById(id).get();
    }

    public void save(Floor floor) {
        floorRepository.save(floor);
    }

    public int update(Floor floor) {
        Floor floor1 = floorRepository.findById(floor.getFloorId()).get();
        floor1.floorCapacity = floor.floorCapacity;
        floor1.floorNumber = floor.floorNumber;
        floorRepository.save(floor1);
        return 1;
    }

    public List<Floor> getAll() {
        return floorRepository.findAll();
    }

    public void delete(Floor floor) {
        floorRepository.delete(floor);
    }

    public void deleteById(Integer id) {
        floorRepository.deleteById(id);
    }
}
