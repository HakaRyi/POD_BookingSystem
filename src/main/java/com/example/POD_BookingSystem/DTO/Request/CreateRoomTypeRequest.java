package com.example.POD_BookingSystem.DTO.Request;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateRoomRequest {
    String building_id;
    String room_name;
    int capacity;
    String availability;
    double price;
    String type_id;
    String description;
    LocalDate available_Date;
}
