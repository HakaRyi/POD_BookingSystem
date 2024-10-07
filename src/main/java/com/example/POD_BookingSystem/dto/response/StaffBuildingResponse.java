package com.example.POD_BookingSystem.DTO.Response;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StaffBuildingResponse {
    String staff_building_id;
    String building_id;
    String userid_id;
    LocalDate start_date;
    LocalDate end_date;
}