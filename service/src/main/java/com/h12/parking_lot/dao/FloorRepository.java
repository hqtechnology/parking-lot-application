package com.h12.parking_lot.dao;

import com.h12.parking_lot.model.floor.Floor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FloorRepository extends JpaRepository<Floor, Integer> {

}
