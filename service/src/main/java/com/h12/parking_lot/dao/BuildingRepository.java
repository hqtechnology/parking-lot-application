package com.h12.parking_lot.dao;

import com.h12.parking_lot.model.Building;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface BuildingRepository extends JpaRepository<Building, String> {
    @Modifying
    @Query(value = "UPDATE buildings SET name = :name WHERE id = :id", nativeQuery = true)
    void updateName(@Param("name") String name, @Param("id") String id);

    @Modifying
    @Query(value = "UPDATE buildings SET name = :name, address = :address WHERE id = :id", nativeQuery = true)
    void updateNameAndAddress(@Param("name") String name,@Param("address") String address, @Param("id") String id);
}
