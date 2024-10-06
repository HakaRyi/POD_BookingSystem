package com.example.POD_BookingSystem.DTO.Request.Slot;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateSlotRequest {
    String slot_id;
    String description;
}
