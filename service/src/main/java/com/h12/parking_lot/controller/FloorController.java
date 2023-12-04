package com.h12.parking_lot.controller;

import com.h12.parking_lot.model.floor.FloorDto;
import com.h12.parking_lot.model.floor.Floor;
import com.h12.parking_lot.service.FloorService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping("/floor")
@SuppressWarnings({"rawtypes"})
public class FloorController {
    private final FloorService floorService;
    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    public FloorController(FloorService floorService) {
        this.floorService = floorService;
    }

    @PostMapping("/")
    public ResponseEntity newFloor(@RequestBody Floor floor) {
        try {
            floorService.save(floor);
            return ResponseEntity.ok().body("Floor saved");
        } catch (Exception e) {
            return ResponseEntity.ok().body(e.getMessage());
        }
    }

    @GetMapping("/")
    public ResponseEntity getFloor(@RequestParam("id") Integer id) {
        try {
            Floor floor = floorService.getById(id);
            FloorDto floorDto = modelMapper.map(floor, FloorDto.class);
            return ResponseEntity.ok().body(floorDto);
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
    public ResponseEntity getFloorById(@PathVariable("id") Integer id) {
        try {
            Floor floor = floorService.getById(id);
            return ResponseEntity.ok().body(floor);
        } catch (Exception e) {
            return ResponseEntity.ok().body(e.getMessage());
        }
    }

    @PutMapping("/")
    public ResponseEntity updateFloor(@RequestBody Floor floor) {
        try {
            int floor1 = floorService.update(floor);
            return ResponseEntity.ok().body("Response from DB: " + floor1);
        } catch (Exception e) {
            return ResponseEntity.ok().body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteFloor(@PathVariable("id") Integer id) {
        try {
            floorService.deleteById(id);
            return ResponseEntity.ok().body("Deleted.");
        } catch (Exception e) {
            return ResponseEntity.ok().body(e.getMessage());
        }
    }
}
