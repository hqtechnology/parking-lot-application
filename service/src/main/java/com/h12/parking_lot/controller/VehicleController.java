package com.h12.parking_lot.controller;

import com.h12.parking_lot.model.vehicle.Vehicle;
import com.h12.parking_lot.model.vehicle.VehicleDto;
import com.h12.parking_lot.service.VehicleService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController()
@RequestMapping("/vehicle")
@SuppressWarnings({"rawtypes"})
public class VehicleController {
    private final VehicleService vehicleService;
    private ModelMapper modelMapper;

    @Autowired
    public VehicleController(VehicleService vehicleService, ModelMapper modelMapper) {
        this.vehicleService = vehicleService;
        this.modelMapper = modelMapper;
    }

    @PostMapping("/")
    public ResponseEntity newVehicle(@RequestBody Vehicle vehicle) {
        try {
            Vehicle vehicle1 = vehicleService.save(vehicle);
            return ResponseEntity.ok().body(modelMapper.map(vehicle1, VehicleDto.class));
        } catch (Exception e) {
            return ResponseEntity.ok().body(e.getMessage());
        }
    }

    @GetMapping("/")
    public ResponseEntity getVehicle(@RequestParam("id") Integer id) {
        try {
            Vehicle vehicle = vehicleService.getById(id);
            return ResponseEntity.ok().body(modelMapper.map(vehicle, VehicleDto.class));
        } catch (Exception e) {
            return ResponseEntity.ok().body(e.getMessage());
        }
    }

    @GetMapping("/all")
    public ResponseEntity getAllVehicles() {
        try {
            List<VehicleDto> vehicleDtoList = new ArrayList<>();
            for (Vehicle vehicle : vehicleService.getAll()) {
                vehicleDtoList.add(modelMapper.map(vehicle, VehicleDto.class));
            }
            return ResponseEntity.ok().body(vehicleDtoList);
        } catch (Exception e) {
            return ResponseEntity.ok().body(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity getVehicleById(@PathVariable("id") Integer id) {
        try {
            Vehicle vehicle = vehicleService.getById(id);
            return ResponseEntity.ok().body(modelMapper.map(vehicle, VehicleDto.class));
        } catch (Exception e) {
            return ResponseEntity.ok().body(e.getMessage());
        }
    }

    @PutMapping("/")
    public ResponseEntity updateVehicle(@RequestBody Vehicle vehicle) {
        try {
            int vehicle1 = vehicleService.update(vehicle);
            return ResponseEntity.ok().body("Response from DB: " + modelMapper.map(vehicle, VehicleDto.class));
        } catch (Exception e) {
            return ResponseEntity.ok().body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteVehicle(@PathVariable("id") Integer id) {
        try {
            vehicleService.deleteById(id);
            return ResponseEntity.ok().body("Deleted.");
        } catch (Exception e) {
            return ResponseEntity.ok().body(e.getMessage());
        }
    }
}
