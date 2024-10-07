package com.example.POD_BookingSystem.dto.request;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UpdateBuildingRequest {
    String name;
    String address;
    String description;
    String location;
}
