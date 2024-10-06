package com.example.POD_BookingSystem.DTO.Response;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SlotResponse {
    String slot_id;
    String description;
}
