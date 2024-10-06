package com.example.POD_BookingSystem.mapper;

import com.example.POD_BookingSystem.dto.request.StaffBuildingRequest;
import com.example.POD_BookingSystem.dto.response.StaffBuildingResponse;
import com.example.POD_BookingSystem.entity.Staff_Building;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface StaffBuildingMapper {
    Staff_Building toStaffBuilding(StaffBuildingRequest request);
    @Mapping(source = "building.building_id", target = "building_id")
    @Mapping(source = "user.userid_id", target = "userid_id")
    StaffBuildingResponse toStaffBuildingResponse(Staff_Building staffBuilding);
}
