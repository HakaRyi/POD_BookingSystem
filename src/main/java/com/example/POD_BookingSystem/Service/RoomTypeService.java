package com.example.POD_BookingSystem.Service;

import com.example.POD_BookingSystem.DTO.Request.CreateBuildingRequest;
import com.example.POD_BookingSystem.DTO.Request.CreateRoomRequest;
import com.example.POD_BookingSystem.DTO.Request.UpdateBuildingRequest;
import com.example.POD_BookingSystem.DTO.Response.BuildingResponse;
import com.example.POD_BookingSystem.DTO.Response.RoomResponse;
import com.example.POD_BookingSystem.Entity.Building;
import com.example.POD_BookingSystem.Exception.AppException;
import com.example.POD_BookingSystem.Exception.ErrorCode;
import com.example.POD_BookingSystem.Mapper.BuildingMapper;
import com.example.POD_BookingSystem.Mapper.RoomMapper;
import com.example.POD_BookingSystem.Repository.BuildingRepository;
import com.example.POD_BookingSystem.Repository.RoomRepository;
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
    RoomMapper roomMapper;

    // Tao Ra 1 BUILDING MOI
    public RoomResponse createRoom (CreateRoomRequest request){
        Building building = buildingRepository.findById(request.getBuilding_id())
                .orElseThrow(() -> new AppException(ErrorCode.ID_NOT_FOUND));
        return buildingMapper.toBuildingResponse(building);
    }

    // TAO ID 1 cach tu dong
    private String GenerateId(){
        String id = roomRepository.findLastId();
        if(!(id == null)){
            int number = Integer.parseInt(id.substring(3))+1;
            return String.format("R-%02d", number);
        }
        return "R-01";
    }

    //Get All Building
    public List<BuildingResponse> getAllBuildings(){
        List<Building> buildings = buildingRepository.findAll();
        return  buildings.stream().map(buildingMapper::toBuildingResponse).collect(Collectors.toList());
    }

    //Get Building By Name
    public List<BuildingResponse> getBuildings(String name){
        List<Building> buildings = buildingRepository.findAllBuildingByName(name);
        return  buildings.stream().map(buildingMapper::toBuildingResponse).collect(Collectors.toList());
    }

    //Update Building
    public BuildingResponse updateBuilding(String id, UpdateBuildingRequest request){
        Building building = buildingRepository.findById(id).orElseThrow(() -> new AppException(ErrorCode.ID_NOT_FOUND));
        buildingMapper.updateBuilding(building, request);
        buildingRepository.save(building);
        return buildingMapper.toBuildingResponse(building);
    }

    //Delete Building
    public void deleteBuilding(String id){
        buildingRepository.deleteById(id);
    }
}
