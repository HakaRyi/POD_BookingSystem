package com.example.POD_BookingSystem.Controller;

import com.example.POD_BookingSystem.DTO.Request.Room.AddServiceRequest;
import com.example.POD_BookingSystem.DTO.Request.Room.CreateRoomRequest;
import com.example.POD_BookingSystem.DTO.Request.Building.UpdateBuildingRequest;
import com.example.POD_BookingSystem.DTO.Request.Room.UpdateRoomRequest;
import com.example.POD_BookingSystem.DTO.Response.ApiResponse;
import com.example.POD_BookingSystem.DTO.Response.BuildingResponse;
import com.example.POD_BookingSystem.DTO.Response.RoomResponse;
import com.example.POD_BookingSystem.Entity.Room;
import com.example.POD_BookingSystem.Service.RoomService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/rooms")
public class RoomController {
    @Autowired
    RoomService roomService;

    //Create Room API
    @PostMapping
    ApiResponse<RoomResponse> createRoom(@RequestBody CreateRoomRequest request){
        return ApiResponse.<RoomResponse>builder()
                .data(roomService.createRoom(request))
                .build();
    }

    //Get All Room API
    @GetMapping
    ApiResponse<List<RoomResponse>> getBuildings(){
        return ApiResponse.<List<RoomResponse>>builder()
                .data(roomService.getAllRooms())
                .build();
    }

    //Get Room By Name API
    @GetMapping("/{name}")
    ApiResponse<List<RoomResponse>> getBuilding(@PathVariable String name){
        return ApiResponse.<List<RoomResponse>>builder()
                .data(roomService.getRoom(name))
                .build();
    }

    //Update Building API
    @PutMapping("/{id}")
    ApiResponse<RoomResponse> updateRoom(@PathVariable String id, @RequestBody UpdateRoomRequest request) {
        return ApiResponse.<RoomResponse>builder().data(roomService.updateRoom(id, request)).build();
    }

    //Delete Room API
    @DeleteMapping("/{id}")
    ApiResponse<Void> deleteRoom(@PathVariable String id) {
        roomService.deleteRoom(id);
        return ApiResponse.<Void>builder().message("Delete Successfully !!!").build();
    }

    @PostMapping("/{id}")
    ApiResponse<Void> addServiceToRoom(@RequestBody AddServiceRequest request, @PathVariable String id){
        roomService.addService(request, id);
        return ApiResponse.<Void>builder()
                .message("Add new service Successfully !!!")
                .build();
    }

}
