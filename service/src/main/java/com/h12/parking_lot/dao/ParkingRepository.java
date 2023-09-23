package com.h12.parking_lot.dao;

import com.h12.parking_lot.model.ParkingSlot;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParkingRepository extends JpaRepository<ParkingSlot, Integer> {
}
