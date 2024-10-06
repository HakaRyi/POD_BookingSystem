package com.example.POD_BookingSystem.controller;

import com.example.POD_BookingSystem.dto.request.CreateRoomTypeRequest;
import com.example.POD_BookingSystem.dto.response.ApiResponse;
import com.example.POD_BookingSystem.dto.response.RoomTypeResponse;
import com.example.POD_BookingSystem.service.RoomTypeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/room-types")
public class RoomTypeController {
    @Autowired
    RoomTypeService roomTypeService;
    @PostMapping
    ApiResponse<RoomTypeResponse> createRoomType(@RequestBody CreateRoomTypeRequest request){

        log.info("At Controller");
        log.info(request.getName());

        return ApiResponse.<RoomTypeResponse>builder()
                .result(roomTypeService.createRoomType(request))
                .build();
    }

    @GetMapping
    ApiResponse<List<RoomTypeResponse>> getAllRoomType(){
        return ApiResponse.<List<RoomTypeResponse>>builder()
                .result(roomTypeService.getAllRoomTypes())
                .build();
    }

}
