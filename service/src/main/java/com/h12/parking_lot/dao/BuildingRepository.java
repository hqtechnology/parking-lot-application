package com.h12.parking_lot.dao;

import com.h12.parking_lot.model.Building;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface BuildingRepository extends JpaRepository<Building, String> {
    @Modifying
    @Transactional
    @Query(value = "UPDATE Building b SET b.name = :name WHERE b.id = :id")
    int updateName(@Param("name") String name, @Param("id") String id);

    @Modifying
    @Transactional
    @Query(value = "UPDATE Building b SET b.name = :name, b.address = :address WHERE b.id = :id")
    int updateNameAndAddress(@Param("name") String name, @Param("address") String address, @Param("id") String id);
}
