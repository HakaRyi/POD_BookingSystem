package com.example.POD_BookingSystem.dto.response;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RoomTypeResponse {
    String type_id;
    String name;
}
