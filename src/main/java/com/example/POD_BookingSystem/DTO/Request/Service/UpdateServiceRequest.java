package com.example.POD_BookingSystem.DTO.Request.Service;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UpdateServiceRequest {
    String name;
    double fee;
    double price;
    String description;
}
