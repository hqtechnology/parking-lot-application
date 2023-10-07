package com.h12.parking_lot.service;

import com.h12.parking_lot.dao.BuildingRepository;
import com.h12.parking_lot.exception.AlreadyExistsException;
import com.h12.parking_lot.exception.NotExistsException;
import com.h12.parking_lot.model.building.Building;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BuildingService {
    @Autowired
    private BuildingRepository buildingRepository;

    public Building getById(String id) {
        return buildingRepository.findById(id).get();
    }

    public List<Building> getAll() {
        return buildingRepository.findAll();
    }

    public void save(Building building) {
        if (buildingRepository.existsById(building.getBuildingId())) {
            throw new AlreadyExistsException("Building Exists Exception.");
        }
        buildingRepository.save(building);
    }

    public void updateName(Building building) {
        if (!buildingRepository.existsById(building.getBuildingId())) {
            throw new NotExistsException("Building Does not exists.");
        }
        buildingRepository.updateName(building.getName(), building.getBuildingId());
    }

    public int update(Building building) {
        if (building.getAddress() == null) {
            return buildingRepository.updateName(building.getName(), building.getBuildingId());
        }
//        buildingRepository.save(building);
//        return 1;
        return buildingRepository.updateNameAndAddress(building.getName(), building.getAddress(), building.getBuildingId());
    }

    public void delete(Building building) {
        buildingRepository.delete(building);
    }

    public void deleteById(String id) {
        buildingRepository.deleteById(id);
    }
}
