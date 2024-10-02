package com.example.POD_BookingSystem.Mapper;

import com.example.POD_BookingSystem.DTO.Request.CreateBuildingRequest;
import com.example.POD_BookingSystem.DTO.Request.CreateRoomRequest;
import com.example.POD_BookingSystem.DTO.Request.UpdateBuildingRequest;
import com.example.POD_BookingSystem.DTO.Response.BuildingResponse;
import com.example.POD_BookingSystem.DTO.Response.RoomResponse;
import com.example.POD_BookingSystem.Entity.Building;
import com.example.POD_BookingSystem.Entity.Room;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface RoomMapper {
    Room toRoom(CreateRoomRequest request);
    RoomResponse toRoomResponse(Room room);
    @Mapping(target = "room_id", ignore = true)
    void updateRoom(@MappingTarget Room room, UpdateBuildingRequest request);
}
