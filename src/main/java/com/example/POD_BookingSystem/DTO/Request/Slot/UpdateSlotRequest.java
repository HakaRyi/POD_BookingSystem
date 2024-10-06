package com.example.POD_BookingSystem.DTO.Request.Slot;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UpdateSlotRequest {
    String description;
}
