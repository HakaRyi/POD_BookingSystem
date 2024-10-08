package com.example.POD_BookingSystem.DTO.Request.Booking;

import com.example.POD_BookingSystem.Entity.Slot;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateBookingDetailRequest {
    String room_id;
    Map<String, Integer> service;
    LocalDate start_time;
    LocalDate end_time;
    List<String> slots;
}
