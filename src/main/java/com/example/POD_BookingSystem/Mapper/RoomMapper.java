package com.example.POD_BookingSystem.Mapper;

import com.example.POD_BookingSystem.DTO.Request.Room.CreateRoomRequest;
import com.example.POD_BookingSystem.DTO.Request.Building.UpdateBuildingRequest;
import com.example.POD_BookingSystem.DTO.Request.Room.UpdateRoomRequest;
import com.example.POD_BookingSystem.DTO.Response.RoomResponse;
import com.example.POD_BookingSystem.Entity.Room;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface RoomMapper {
    Room toRoom(CreateRoomRequest request);

    @Mapping(source = "building.building_id", target = "building_id")
    @Mapping(source = "roomType.type_id", target = "type_id")
    RoomResponse toRoomResponse(Room room);

    @Mapping(target = "room_id", ignore = true)
    void updateRoom(@MappingTarget Room room, UpdateRoomRequest request);
}
