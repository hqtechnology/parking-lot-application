package com.h12.parking_lot.model.building;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

@Data
@JsonPropertyOrder({
        "buildingId",
        "name",
        "address"
})
public class BuildingDto {
    public String name;
    public String address;
    private String buildingId;
}
