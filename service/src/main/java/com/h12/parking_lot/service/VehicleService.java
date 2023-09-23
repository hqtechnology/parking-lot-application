package com.h12.parking_lot.service;

import com.h12.parking_lot.dao.VehicleRepository;
import com.h12.parking_lot.model.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleService {
    private final VehicleRepository vehicleRepository;

    @Autowired
    public VehicleService(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    public Vehicle getById(Integer id) {
        return vehicleRepository.findById(id).get();
    }

    public void save(Vehicle vehicle) {
        vehicleRepository.save(vehicle);
    }

    public int update(Vehicle vehicle) {
        Vehicle vehicle1 = vehicleRepository.findById(vehicle.getId()).get();
        vehicle1.type = vehicle.type;
        vehicleRepository.save(vehicle1);
        return 1;
    }

    public List<Vehicle> getAll() {
        return vehicleRepository.findAll();
    }

    public void delete(Vehicle vehicle) {
        vehicleRepository.delete(vehicle);
    }

    public void deleteById(Integer id) {
        vehicleRepository.deleteById(id);
    }
}
