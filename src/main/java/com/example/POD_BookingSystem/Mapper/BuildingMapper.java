package com.example.POD_BookingSystem.Mapper;

import com.example.POD_BookingSystem.DTO.Request.CreateBuildingRequest;
import com.example.POD_BookingSystem.DTO.Response.BuildingResponse;
import com.example.POD_BookingSystem.Entity.Building;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BuildingMapper {
    public Building toBuilding(CreateBuildingRequest request);
    public BuildingResponse toBuildingResponse(Building building);
}
