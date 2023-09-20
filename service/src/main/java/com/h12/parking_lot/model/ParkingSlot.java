package com.h12.parking_lot.model;

public class ParkingSlot implements Slot {
    private VehicleType vehicleType;
    private boolean isOccupied;

    public ParkingSlot() {
        this(false);
    }

    public ParkingSlot(boolean isOccupied) {
        this.isOccupied = isOccupied;
        this.vehicleType = VehicleType.DEFAULT;
    }

    public void updateSlot(boolean isOccupied, VehicleType vehicleType) {
        this.isOccupied = isOccupied;
        this.vehicleType = vehicleType;
    }
}
