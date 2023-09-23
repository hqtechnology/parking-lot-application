package com.h12.parking_lot.controller;

import com.h12.parking_lot.model.Floor;
import com.h12.parking_lot.service.FloorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping("/floor")
@SuppressWarnings({"rawtypes"})
public class FloorController {
    private final FloorService floorService;

    @Autowired
    public FloorController(FloorService floorService) {
        this.floorService = floorService;
    }

    @PostMapping("/")
    public ResponseEntity newFloor(@RequestBody Floor building) {
        try {
            floorService.save(building);
            return ResponseEntity.ok().body("Floor saved");
        } catch (Exception e) {
            return ResponseEntity.ok().body(e.getMessage());
        }
    }

    @GetMapping("/")
    public ResponseEntity getFloor(@RequestParam("id") String id) {
        try {
            Floor building = floorService.getById(id);
            return ResponseEntity.ok().body(building);
        } catch (Exception e) {
            return ResponseEntity.ok().body(e.getMessage());
        }
    }

    @GetMapping("/all")
    public ResponseEntity getAllFloor() {
        try {
            return ResponseEntity.ok().body(floorService.getAll());
        } catch (Exception e) {
            return ResponseEntity.ok().body(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity getFloorById(@PathVariable("id") String id) {
        try {
            Floor building = floorService.getById(id);
            return ResponseEntity.ok().body(building);
        } catch (Exception e) {
            return ResponseEntity.ok().body(e.getMessage());
        }
    }

    @PutMapping("/")
    public ResponseEntity updateFloor(@RequestBody Floor building) {
        try {
            int building1 = floorService.update(building);
            return ResponseEntity.ok().body("Response from DB: " + building1);
        } catch (Exception e) {
            return ResponseEntity.ok().body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteFloor(@PathVariable("id") String id) {
        try {
            floorService.deleteById(id);
            return ResponseEntity.ok().body("Deleted.");
        } catch (Exception e) {
            return ResponseEntity.ok().body(e.getMessage());
        }
    }
}
