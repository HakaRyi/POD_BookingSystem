package com.example.POD_BookingSystem.DTO.Request.RoomType;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class CreateRoomTypeRequest {
    String name;
}
