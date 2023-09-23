package com.h12.parking_lot.service;

import com.h12.parking_lot.dao.BuildingRepository;
import com.h12.parking_lot.model.Building;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BuildingService {
    @Autowired
    private BuildingRepository buildingRepository;

    public Building getById(String id) {
        return buildingRepository.getReferenceById(id);
    }

    public List<Building> getAll() {
        return buildingRepository.findAll();
    }

    public void save(Building building) {
        buildingRepository.save(building);
    }

    public void updateName(Building building) {
        buildingRepository.updateName(building.getName(), building.getId());
    }

    public int update(Building building) {
        if(building.getAddress() == null) {
            return buildingRepository.updateName(building.getName(), building.getId());
        }
//        buildingRepository.save(building);
//        return 1;
        return buildingRepository.updateNameAndAddress(building.getName(), building.getAddress(), building.getId());
    }

    public void delete(Building building) {
        buildingRepository.delete(building);
    }

    public void deleteById(String id) {
        buildingRepository.deleteById(id);
    }
}
