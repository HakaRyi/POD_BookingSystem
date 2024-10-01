package com.example.POD_BookingSystem.Service;

import com.example.POD_BookingSystem.DTO.Request.CreateBuildingRequest;
import com.example.POD_BookingSystem.DTO.Response.BuildingResponse;
import com.example.POD_BookingSystem.Entity.Building;
import com.example.POD_BookingSystem.Mapper.BuildingMapper;
import com.example.POD_BookingSystem.Repository.BuildingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BuildingService {
    @Autowired
    BuildingRepository buildingRepository;
    @Autowired
    BuildingMapper buildingMapper;

    // Tao Ra 1 BUILDING MOI
    public BuildingResponse createBuilding (CreateBuildingRequest request){
        Building building = Building.builder()
                .building_id(GenerateId())
                .building_name(request.getBuilding_name())
                .description(request.getDescription())
                .address(request.getAddress())
                .location(request.getLocation())
                .build();
        buildingRepository.save(building);
        return buildingMapper.toBuildingResponse(building);
    }

    // TAO ID 1 cach tu dong
    private String GenerateId(){
        String id = buildingRepository.findLastId();
        if(!(id == null)){
            int number = Integer.parseInt(id.substring(3))+1;
            return String.format("BD-%02d", number);
        }
        return "BD-01";
    }
}
