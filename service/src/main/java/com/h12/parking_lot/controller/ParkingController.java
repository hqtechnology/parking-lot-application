package com.h12.parking_lot.controller;

import com.h12.parking_lot.model.parking.ParkingSlot;
import com.h12.parking_lot.service.ParkingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping("/parking")
@SuppressWarnings({"rawtypes"})
public class ParkingController {

    private final ParkingService parkingService;

    @Autowired
    public ParkingController(ParkingService parkingService) {
        this.parkingService = parkingService;
    }

    @GetMapping("/freeSlots")
    public ResponseEntity getFreeSlots(int parkingSlotNumber) {
        //TODO: Logic to be implemented.
        return ResponseEntity.ok().build();
    }

    @PostMapping("/reserve")
    public ResponseEntity newParkingSlot(@RequestBody ParkingSlot parkingSlot) {
        try {
            parkingService.save(parkingSlot);
            return ResponseEntity.ok().body("ParkingSlot saved");
        } catch (Exception e) {
            return ResponseEntity.ok().body(e.getMessage());
        }
    }

    @GetMapping("/")
    public ResponseEntity getParkingSlot(@RequestParam("id") Integer id) {
        try {
            ParkingSlot parkingSlot = parkingService.getById(id);
            return ResponseEntity.ok().body(parkingSlot);
        } catch (Exception e) {
            return ResponseEntity.ok().body(e.getMessage());
        }
    }

    @GetMapping("/all")
    public ResponseEntity getAllParkingSlot() {
        try {
            return ResponseEntity.ok().body(parkingService.getAll());
        } catch (Exception e) {
            return ResponseEntity.ok().body(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity getParkingSlotById(@PathVariable("id") Integer id) {
        try {
            ParkingSlot parkingSlot = parkingService.getById(id);
            return ResponseEntity.ok().body(parkingSlot);
        } catch (Exception e) {
            return ResponseEntity.ok().body(e.getMessage());
        }
    }

    @PutMapping("/")
    public ResponseEntity updateParkingSlot(@RequestBody ParkingSlot parkingSlot) {
        try {
            int parkingSlot1 = parkingService.update(parkingSlot);
            return ResponseEntity.ok().body("Response from DB: " + parkingSlot1);
        } catch (Exception e) {
            return ResponseEntity.ok().body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteParkingSlot(@PathVariable("id") Integer id) {
        try {
            parkingService.deleteById(id);
            return ResponseEntity.ok().body("Deleted.");
        } catch (Exception e) {
            return ResponseEntity.ok().body(e.getMessage());
        }
    }

}
