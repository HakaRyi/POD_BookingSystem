package com.example.POD_BookingSystem.dto.response;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RoomResponse {
    String room_id;
    String building_id;
    String name;
    int capacity;
    String availability;
    double price;
    String type_id;
    String description;
    LocalDate available_Date;

    public RoomResponse(String roomId, String availability) {

    }
}
