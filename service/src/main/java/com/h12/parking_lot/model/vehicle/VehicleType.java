package com.h12.parking_lot.model.vehicle;

import lombok.Getter;

@Getter
public enum VehicleType {
    COMPACT(0),
    BIKE(1),
    TRUCK(2);

    private final int order;

    VehicleType(int order) {
        this.order = order;
    }

}
