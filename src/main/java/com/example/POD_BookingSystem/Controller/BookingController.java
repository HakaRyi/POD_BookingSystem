package com.example.POD_BookingSystem.Controller;

import com.example.POD_BookingSystem.DTO.Request.Booking.CreateBookingDetailRequest;
import com.example.POD_BookingSystem.DTO.Request.Building.CreateBuildingRequest;
import com.example.POD_BookingSystem.DTO.Request.Building.UpdateBuildingRequest;
import com.example.POD_BookingSystem.DTO.Response.ApiResponse;
import com.example.POD_BookingSystem.DTO.Response.BuildingResponse;
import com.example.POD_BookingSystem.Entity.EBooking.BookingDetail;
import com.example.POD_BookingSystem.Entity.Room;
import com.example.POD_BookingSystem.Repository.ReRoom.RoomRepository;
import com.example.POD_BookingSystem.Service.BuildingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookingController {

    @Autowired
    RoomRepository roomRepository;

    @PostMapping({"/{roomName}/booking"})
    public ResponseEntity<BookingDetail> createBookingDetail(@PathVariable String roomName,
                                                             @RequestBody CreateBookingDetailRequest request){


    }
}
