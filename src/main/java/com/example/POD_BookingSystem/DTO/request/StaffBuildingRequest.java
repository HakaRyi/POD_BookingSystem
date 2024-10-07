package com.example.POD_BookingSystem.dto.request;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StaffBuildingRequest {

    String name; //building name
    String username;
    LocalDate start_date;
    LocalDate end_date;
}
