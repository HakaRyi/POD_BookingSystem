package com.example.POD_BookingSystem.service;

import com.example.POD_BookingSystem.dto.request.CreateRoomRequest;
import com.example.POD_BookingSystem.dto.request.UpdateRoomRequest;
import com.example.POD_BookingSystem.dto.response.RoomResponse;
import com.example.POD_BookingSystem.entity.Building;
import com.example.POD_BookingSystem.entity.Room;
import com.example.POD_BookingSystem.entity.Room_Type;
import com.example.POD_BookingSystem.exception.AppException;
import com.example.POD_BookingSystem.exception.ErrorCode;
import com.example.POD_BookingSystem.mapper.RoomMapper;
import com.example.POD_BookingSystem.repository.BuildingRepository;
import com.example.POD_BookingSystem.repository.RoomRepository;
import com.example.POD_BookingSystem.repository.RoomTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RoomService {
    @Autowired
    RoomRepository roomRepository;
    @Autowired
    BuildingRepository buildingRepository;
    @Autowired
    RoomTypeRepository roomTypeRepository;
    @Autowired
    RoomMapper roomMapper;

    // Tao Ra 1 Room MOI
    public RoomResponse createRoom (CreateRoomRequest request){
        Building building = buildingRepository.findByName(request.getBuilding_name());
        if(building == null) throw new AppException(ErrorCode.NAME_NOT_FOUND);

        Room_Type roomType = roomTypeRepository.findByName(request.getType_name());
        if(roomType == null) throw new RuntimeException("Room type not found");

        Room room = Room.builder()
                .room_id(GenerateId())
                .name(request.getName())
                .availability(request.getAvailability())
                .price(request.getPrice())
                .available_Date(request.getAvailable_Date())
                .building(building)
                .capacity(request.getCapacity())
                .description(request.getDescription())
                .roomType(roomType)
                .build();

        roomRepository.save(room);
        RoomResponse result = roomMapper.toRoomResponse(room);
        result.setBuilding_id(building.getBuilding_id());
        result.setType_id(roomType.getType_id());
        return result;
    }

    // TAO ID 1 cach tu dong
    private String GenerateId(){
        String id = roomRepository.findLastId();
        if(!(id == null)){
            int number = Integer.parseInt(id.substring(2))+1;
            return String.format("R-%02d", number);
        }
        return "R-01";
    }

    //Get All Room
    public List<RoomResponse> getAllRooms(){
        List<Room> rooms = roomRepository.findAll();

        return rooms.stream().map(roomMapper::toRoomResponse).collect(Collectors.toList());
    }

    //Get Room By Name
    public List<RoomResponse> getRoom(String name){
        List<Room> rooms = roomRepository.findAllRoomByName(name);
        return  rooms.stream().map(roomMapper::toRoomResponse).collect(Collectors.toList());
    }
    //Get Room By Building
    public List<RoomResponse> getRoomByBuilding(String building){
        List<Room> rooms = roomRepository.findRoomByBuilding(building);
        return  rooms.stream().map(roomMapper::toRoomResponse).collect(Collectors.toList());

    }
    //Get Room By RoomType
    public List<RoomResponse> getRoomByType(String type){
        List<Room> rooms = roomRepository.findAllRoomByType(type);
        return  rooms.stream().map(roomMapper::toRoomResponse).collect(Collectors.toList());

    }

    //Get Room By Status
    public List<RoomResponse> getRoomByStatus(){
        List<Room> rooms = roomRepository.findRoomByStatus();
        return  rooms.stream().map(roomMapper::toRoomResponse).collect(Collectors.toList());

    }

    //Update Room
    public RoomResponse updateRoom(String id, UpdateRoomRequest request){
        Room room = roomRepository.findById(id).orElseThrow(() -> new AppException(ErrorCode.ID_NOT_FOUND));
        roomMapper.updateRoom(room, request);
        roomRepository.save(room);
        return roomMapper.toRoomResponse(room);
    }

    //Delete Room
    public void deleteRoom(String id){
        roomRepository.deleteById(id);
    }
}
