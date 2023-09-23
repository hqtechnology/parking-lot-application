package com.h12.parking_lot.service;

import com.h12.parking_lot.dao.FloorRepository;
import com.h12.parking_lot.model.Floor;
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

    public Floor getById(String id) {
        return floorRepository.getReferenceById(id);
    }

    public void save(Floor floor) {
        floorRepository.save(floor);
    }

    public void updateName(Floor floor) {
        floorRepository.save(floor);
    }

    public int update(Floor floor) {
        floorRepository.save(floor);
        return 1;
    }

    public List<Floor> getAll() {
        return floorRepository.findAll();
    }

    public void delete(Floor floor) {
        floorRepository.delete(floor);
    }

    public void deleteById(String id) {
        floorRepository.deleteById(id);
    }
}
