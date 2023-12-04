package com.h12.parking_lot.model.floor;

import lombok.Data;

@Data
public class FloorDto {
    public int floorCapacity;
    public int floorNumber;
    private Integer floorId;

    @Data
    public static class ParkingLotDto {
        public int slotNumber;
        public boolean isOccupied;
        private Integer parkingId;
    }
}
