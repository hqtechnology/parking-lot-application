package com.h12.parking_lot.controller;

import com.h12.parking_lot.model.Vehicle;
import com.h12.parking_lot.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping("/vehicle")
@SuppressWarnings({"rawtypes"})
public class VehicleController {
    private final VehicleService vehicleService;

    @Autowired
    public VehicleController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @PostMapping("/")
    public ResponseEntity newVehicle(@RequestBody Vehicle vehicle) {
        try {
            vehicleService.save(vehicle);
            return ResponseEntity.ok().body("Vehicle saved");
        } catch (Exception e) {
            return ResponseEntity.ok().body(e.getMessage());
        }
    }

    @GetMapping("/")
    public ResponseEntity getVehicle(@RequestParam("id") Integer id) {
        try {
            Vehicle vehicle = vehicleService.getById(id);
            return ResponseEntity.ok().body(vehicle);
        } catch (Exception e) {
            return ResponseEntity.ok().body(e.getMessage());
        }
    }

    @GetMapping("/all")
    public ResponseEntity getAllVehicles() {
        try {
            return ResponseEntity.ok().body(vehicleService.getAll());
        } catch (Exception e) {
            return ResponseEntity.ok().body(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity getVehicleById(@PathVariable("id") Integer id) {
        try {
            Vehicle vehicle = vehicleService.getById(id);
            return ResponseEntity.ok().body(vehicle);
        } catch (Exception e) {
            return ResponseEntity.ok().body(e.getMessage());
        }
    }

    @PutMapping("/")
    public ResponseEntity updateVehicle(@RequestBody Vehicle vehicle) {
        try {
            int vehicle1 = vehicleService.update(vehicle);
            return ResponseEntity.ok().body("Response from DB: " + vehicle1);
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
