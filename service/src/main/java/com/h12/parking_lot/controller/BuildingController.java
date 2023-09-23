package com.h12.parking_lot.controller;

import com.h12.parking_lot.model.Building;
import com.h12.parking_lot.service.BuildingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping("/buildings")
@SuppressWarnings("rawtypes")
public class BuildingController {
    @Autowired
    private BuildingService buildingService;

    @PostMapping("/")
    public ResponseEntity newBuilding(@RequestBody Building building) {
        try {
            buildingService.save(building);
            return ResponseEntity.ok().body("Building saved");
        } catch (Exception e) {
            return ResponseEntity.ok().body(e.getMessage());
        }
    }

    @GetMapping("/")
    public ResponseEntity getBuilding(@RequestParam("id") String id) {
        try {
            Building building = buildingService.getById(id);
            return ResponseEntity.ok().body(building);
        } catch (Exception e) {
            return ResponseEntity.ok().body(e.getMessage());
        }
    }

    @GetMapping("/all")
    public ResponseEntity getAllBuilding() {
        try {
            return ResponseEntity.ok().body(buildingService.getAll());
        } catch (Exception e) {
            return ResponseEntity.ok().body(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity getBuildingById(@PathVariable("id") String id) {
        try {
            Building building = buildingService.getById(id);
            return ResponseEntity.ok().body(building);
        } catch (Exception e) {
            return ResponseEntity.ok().body(e.getMessage());
        }
    }

    @PutMapping("/")
    public ResponseEntity updateBuilding(@RequestBody Building building) {
        try {
            int building1 = buildingService.update(building);
            return ResponseEntity.ok().body("Response from DB: " + building1);
        } catch (Exception e) {
            return ResponseEntity.ok().body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteBuilding(@PathVariable("id") String id) {
        try {
            buildingService.deleteById(id);
            return ResponseEntity.ok().body("Deleted.");
        } catch (Exception e) {
            return ResponseEntity.ok().body(e.getMessage());
        }
    }

}
