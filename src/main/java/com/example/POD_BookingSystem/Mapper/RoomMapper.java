package com.example.POD_BookingSystem.mapper;

import com.example.POD_BookingSystem.dto.request.CreateRoomRequest;
import com.example.POD_BookingSystem.dto.request.UpdateRoomRequest;
import com.example.POD_BookingSystem.dto.response.RoomResponse;
import com.example.POD_BookingSystem.entity.Room;
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
