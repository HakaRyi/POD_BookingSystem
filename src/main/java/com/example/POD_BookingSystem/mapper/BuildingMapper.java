package com.example.POD_BookingSystem.mapper;

import com.example.POD_BookingSystem.DTO.Request.Building.CreateBuildingRequest;
import com.example.POD_BookingSystem.DTO.Request.Building.UpdateBuildingRequest;
import com.example.POD_BookingSystem.dto.response.BuildingResponse;
import com.example.POD_BookingSystem.entity.Building;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface BuildingMapper {
    Building toBuilding(CreateBuildingRequest request);
    BuildingResponse toBuildingResponse(Building building);
    @Mapping(target = "building_id", ignore = true)
    void updateBuilding(@MappingTarget Building building, UpdateBuildingRequest request);
}
