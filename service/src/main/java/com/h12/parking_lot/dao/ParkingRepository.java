package com.h12.parking_lot.dao;

import com.h12.parking_lot.model.Building;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ParkingRepository extends JpaRepository<Building, Integer> {

    @Query(value = "SELECT * FROM BUILDING b WHERE b.id = ?1")
    Building getById(String id);
}
