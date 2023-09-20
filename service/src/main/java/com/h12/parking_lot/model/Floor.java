package com.h12.parking_lot.model;

import java.util.ArrayList;
import java.util.List;

public class Floor {
    private static List<ParkingSlot> slots;
    private final int floorCapacity;

    public Floor(int capacity) {
        this.floorCapacity = capacity;
        Floor.slots = new ArrayList<>(capacity + 1);
    }

    public List<Integer> getFreeSlots() {
        List<Integer> freeSlots = new ArrayList<>(floorCapacity);
        for (int i = 0; i < floorCapacity; i++) {

        }
        return null;
    }

    public void park(int index, ParkingSlot parkingSlot) {
        slots.add(index, parkingSlot);
    }


}
