package com.example.POD_BookingSystem.Controller;

import com.example.POD_BookingSystem.DTO.Request.RoomType.CreateRoomTypeRequest;
import com.example.POD_BookingSystem.DTO.Response.ApiResponse;
import com.example.POD_BookingSystem.DTO.Response.RoomTypeResponse;
import com.example.POD_BookingSystem.Service.RoomTypeService;
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
                .data(roomTypeService.createRoomType(request))
                .build();
    }

    @GetMapping
    ApiResponse<List<RoomTypeResponse>> getAllRoomType(){
        return ApiResponse.<List<RoomTypeResponse>>builder()
                .data(roomTypeService.getAllRoomTypes())
                .build();
    }
}
