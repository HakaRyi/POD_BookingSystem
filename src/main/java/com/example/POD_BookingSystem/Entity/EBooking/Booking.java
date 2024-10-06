package com.example.POD_BookingSystem.Entity.EBooking;

import com.example.POD_BookingSystem.Entity.Slot;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.util.List;

@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "booking")
public class Booking {
    @Id
    String booking_id;
    String user_id;
    LocalDate booking_date;
    double total;

    @ManyToMany
    @JoinTable(
            name = "Room_slot",
            joinColumns = @JoinColumn(name = "booking_id"),
            inverseJoinColumns = @JoinColumn(name = "slot_id")
    )
    List<Slot> slots;
}
