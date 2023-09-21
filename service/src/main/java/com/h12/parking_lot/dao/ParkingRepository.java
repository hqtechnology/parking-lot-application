package com.h12.parking_lot.dao;

import com.h12.parking_lot.model.Building;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ParkingRepository extends JpaRepository<Building, String> {
    Optional<Building> findById(String id);
}
