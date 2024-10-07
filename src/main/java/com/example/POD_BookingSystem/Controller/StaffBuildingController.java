package com.example.POD_BookingSystem.controller;

import com.example.POD_BookingSystem.dto.request.StaffBuildingRequest;
import com.example.POD_BookingSystem.dto.response.ApiResponse;
import com.example.POD_BookingSystem.dto.response.RoomResponse;
import com.example.POD_BookingSystem.dto.response.StaffBuildingResponse;
import com.example.POD_BookingSystem.service.StaffBuildingService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/staffBuilding")
public class StaffBuildingController {
    @Autowired
    StaffBuildingService staffBuildingService;

    @PostMapping
    ApiResponse<StaffBuildingResponse> createStaffBuilding(@RequestBody StaffBuildingRequest request){
        return ApiResponse.<StaffBuildingResponse>builder()
                .result(staffBuildingService.createStaffBuilding(request))
                .build();
    }

    @GetMapping
    ApiResponse<List<StaffBuildingResponse>> getStaffBuildings(){
        return ApiResponse.<List<StaffBuildingResponse>>builder()
                .result(staffBuildingService.getAllStaffBuilding())
                .build();
    }

    @GetMapping("/building/{id}")
    ApiResponse<List<StaffBuildingResponse>> getRoomByBuilding(@PathVariable("id") String building){
        return ApiResponse.<List<StaffBuildingResponse>>builder()
                .result(staffBuildingService.getAllStaffBuildingbyBuilding(building))
                .build();
    }

    @DeleteMapping("/{id}")
    ApiResponse<Void> deleteRoom(@PathVariable String id) {
        staffBuildingService.deleteStaffBuilding(id);
        return ApiResponse.<Void>builder().message("Delete Successfully !!!").build();
    }

}
