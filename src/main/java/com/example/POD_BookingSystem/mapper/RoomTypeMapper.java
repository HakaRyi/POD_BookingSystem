package com.example.POD_BookingSystem.mapper;

import com.example.POD_BookingSystem.DTO.Request.Building.UpdateBuildingRequest;
import com.example.POD_BookingSystem.dto.response.RoomTypeResponse;
import com.example.POD_BookingSystem.entity.Room_Type;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface RoomTypeMapper {
    RoomTypeResponse toRoomTypeResponse(Room_Type roomType);

    @Mapping(target = "type_id", ignore = true)
    void updateRoom(@MappingTarget Room_Type room_type, UpdateBuildingRequest request);
}
