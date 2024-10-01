package com.example.POD_BookingSystem.DTO.Request;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UpdateBuildingRequest {
    String building_name;
    String address;
    String description;
    String location;
}
