package com.example.POD_BookingSystem.Controller;

import com.example.POD_BookingSystem.DTO.Request.Room.CreateRoomRequest;
import com.example.POD_BookingSystem.DTO.Request.Room.UpdateRoomRequest;
import com.example.POD_BookingSystem.DTO.Response.ApiResponse;
import com.example.POD_BookingSystem.DTO.Response.RoomResponse;
import com.example.POD_BookingSystem.Service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rooms")
public class RoomController {
    @Autowired
    RoomService roomService;
    @PostMapping
    ApiResponse<RoomResponse> createRoom(@RequestBody CreateRoomRequest request){
        return ApiResponse.<RoomResponse>builder()
                .data(roomService.createRoom(request))
                .build();
    }

    //Get All Room API
    @GetMapping
    ApiResponse<List<RoomResponse>> getRooms(){
        return ApiResponse.<List<RoomResponse>>builder()
                .data(roomService.getAllRooms())
                .build();
    }

    //Get Room By Name API
    @GetMapping("/name/{name}")
    ApiResponse<List<RoomResponse>> getRoomByName(@PathVariable("name") String name){
        return ApiResponse.<List<RoomResponse>>builder()
                .data(roomService.getRoom(name))
                .build();
    }

    @GetMapping("/building/{id}")
    ApiResponse<List<RoomResponse>> getRoomByBuilding(@PathVariable("id") String building){
        return ApiResponse.<List<RoomResponse>>builder()
                .data(roomService.getRoomByBuilding(building))
                .build();
    }

    @GetMapping("/type/{id}")
    ApiResponse<List<RoomResponse>> getRoomByType(@PathVariable("id") String type){
        return ApiResponse.<List<RoomResponse>>builder()
                .data(roomService.getRoomByType(type))
                .build();
    }

    @GetMapping("/status")
    ApiResponse<List<RoomResponse>> getRoomByStatus(){
        return ApiResponse.<List<RoomResponse>>builder()
                .data(roomService.getRoomByStatus())
                .build();
    }


    //Update Room API
    @PutMapping("/id/{id}")
    ApiResponse<RoomResponse> updateRoom(@PathVariable String id, @RequestBody UpdateRoomRequest request) {
        return ApiResponse.<RoomResponse>builder().data(roomService.updateRoom(id, request)).build();
    }


    //Delete Room API
    @DeleteMapping("/{id}")
    ApiResponse<Void> deleteRoom(@PathVariable String id) {
        roomService.deleteRoom(id);
        return ApiResponse.<Void>builder().message("Delete Successfully !!!").build();
    }
}
