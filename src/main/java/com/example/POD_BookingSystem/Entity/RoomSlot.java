package com.example.POD_BookingSystem.Entity;

import com.example.POD_BookingSystem.Entity.EBooking.Booking;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Entity

@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Room_slot")
public class RoomSlot {

    @EmbeddedId
    private RoomSlotId id;

    @ManyToOne
    @MapsId("room_id")
    @JoinColumn(name = "room_id")
    private Room room;

    @ManyToOne
    @MapsId("slot_id")
    @JoinColumn(name = "slot_id")
    private Slot slot;

    @ManyToOne
    @MapsId("booking_id")
    @JoinColumn(name = "booking_id")
    private Booking booking;

    LocalDate booking_date;
}
