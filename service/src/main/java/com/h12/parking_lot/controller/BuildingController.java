package com.h12.parking_lot.controller;

import com.h12.parking_lot.model.building.Building;
import com.h12.parking_lot.model.building.BuildingDto;
import com.h12.parking_lot.response.model.Response;
import com.h12.parking_lot.service.BuildingService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController()
@RequestMapping("/building")
@SuppressWarnings("rawtypes")
public class BuildingController {
    @Autowired
    private BuildingService buildingService;
    @Autowired
    private ModelMapper modelMapper;

    @PostMapping("/")
    public ResponseEntity<Response> newBuilding(@RequestBody Building building) {
        try {
            buildingService.save(building);
            return ResponseEntity.ok().body(Response.of(null, "Building saved.", null));
        } catch (Exception e) {
            return ResponseEntity.ok().body(Response.of(null, "", null));
        }
    }

    @GetMapping("/")
    public ResponseEntity<Response> getBuilding(@RequestParam("id") String id) {
        try {
            Building building = buildingService.getById(id);
            BuildingDto buildingDto = modelMapper.map(building, BuildingDto.class);
            return ResponseEntity.ok().body(Response.of(buildingDto));
        } catch (Exception e) {
            return ResponseEntity.ok().body(Response.of(null, e.getMessage(), null));
        }
    }

    @GetMapping("/all")
    public ResponseEntity<Response> getAllBuilding() {
        try {
            List<BuildingDto> buildingDtoList = new ArrayList<>();
            for (Building b :
                    buildingService.getAll()) {
                buildingDtoList.add(modelMapper.map(b, BuildingDto.class));
            }
            return ResponseEntity.ok().body(Response.of(buildingDtoList));
        } catch (Exception e) {
            return ResponseEntity.ok().body(Response.of(null, e.getMessage(), null));
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity getBuildingById(@PathVariable("id") String id) {
        try {
            Building building = buildingService.getById(id);
            BuildingDto buildingDto = modelMapper.map(building, BuildingDto.class);
            return ResponseEntity.ok().body(buildingDto);
        } catch (Exception e) {
            return ResponseEntity.ok().body(e.getMessage());
        }
    }

    @PutMapping("/")
    public ResponseEntity<Response> updateBuilding(@RequestBody Building building) {
        try {
            int building1 = buildingService.update(building);
            return ResponseEntity.ok().body(Response.of("Updated building: " + building1));
        } catch (Exception e) {
            return ResponseEntity.ok().body(Response.of(null, e.getMessage(), null));
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Response> deleteBuilding(@PathVariable("id") String id) {
        try {
            buildingService.deleteById(id);
            return ResponseEntity.ok().body(Response.of("DELETED."));
        } catch (Exception e) {
            return ResponseEntity.ok().body(Response.of(null, e.getMessage(), null));
        }
    }
}
