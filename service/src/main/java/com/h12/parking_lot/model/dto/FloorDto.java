package com.h12.parking_lot.model.dto;

import lombok.Data;

@Data
public class FloorDto {
    public int floorCapacity;
    public int floorNumber;
    private Integer floorId;
}
