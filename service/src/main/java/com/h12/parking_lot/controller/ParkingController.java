package com.h12.parking_lot.controller;

import com.h12.parking_lot.service.ParkingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public ResponseEntity getFreeSlots(int buildingNumber) {
        return ResponseEntity.ok().build();
    }

}
