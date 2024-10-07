package com.example.POD_BookingSystem.controller;

import com.example.POD_BookingSystem.DTO.Request.Building.CreateBuildingRequest;
import com.example.POD_BookingSystem.DTO.Request.Building.UpdateBuildingRequest;
import com.example.POD_BookingSystem.dto.response.ApiResponse;
import com.example.POD_BookingSystem.dto.response.BuildingResponse;
import com.example.POD_BookingSystem.service.BuildingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/buildings")
public class BuildingController {
    @Autowired
    BuildingService buildingService;

    //Create Building API
    @PostMapping
    ApiResponse<BuildingResponse> createBuilding(@RequestBody CreateBuildingRequest request){
        return ApiResponse.<BuildingResponse>builder()
                .result(buildingService.createBuilding(request))
                .build();
    }

    //Get All Building API
    @GetMapping
    ApiResponse<List<BuildingResponse>> getBuildings(){
        return ApiResponse.<List<BuildingResponse>>builder()
                .result(buildingService.getAllBuildings())
                .build();
    }

    //Get Building By Name API
    @GetMapping("/name/{name}")
    ApiResponse<List<BuildingResponse>> getBuilding(@PathVariable("name") String name){
        return ApiResponse.<List<BuildingResponse>>builder()
                .result(buildingService.getBuildings(name))
                .build();
    }

    //Get Building By Location API
    @GetMapping("/location/{name}")
    ApiResponse<List<BuildingResponse>> getBuildingByLocation(@PathVariable("name") String name){
        return ApiResponse.<List<BuildingResponse>>builder()
                .result(buildingService.getBuildingsByLocation(name))
                .build();
    }

    //Update Building API
    @PutMapping("/{id}")
    ApiResponse<BuildingResponse> updateBuilding(@PathVariable String id, @RequestBody UpdateBuildingRequest request) {
        return ApiResponse.<BuildingResponse>builder().result(buildingService.updateBuilding(id, request)).build();
    }

    //Delete Building API
    @DeleteMapping("/{id}")
    ApiResponse<Void> deleteBuilding(@PathVariable String id) {
        buildingService.deleteBuilding(id);
        return ApiResponse.<Void>builder().message("Delete Successfully !!!").build();
    }

}
