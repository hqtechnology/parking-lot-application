package com.h12.parking_lot.controller;

import com.h12.parking_lot.service.ParkingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

@Controller
public class ParkingController {

    private final ParkingService parkingService;

    @Autowired
    public ParkingController(ParkingService parkingService) {
        this.parkingService = parkingService;
    }

    public ResponseEntity getFreeSlots(int buildingNumber) {
        return ResponseEntity.ok().body(parkingService.getFreeSlots(buildingNumber));
    }

}
