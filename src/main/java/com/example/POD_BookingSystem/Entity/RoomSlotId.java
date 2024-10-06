package com.example.POD_BookingSystem.Entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;
import java.time.LocalDate;

@Embeddable
@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RoomSlotId implements Serializable {

     String booking_id;
     String room_id;
     String slot_id;


}