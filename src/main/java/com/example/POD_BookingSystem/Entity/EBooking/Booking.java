package com.example.POD_BookingSystem.Entity.EBooking;

import com.example.POD_BookingSystem.Entity.Room;
import com.example.POD_BookingSystem.Entity.Service;
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
            joinColumns = @JoinColumn(name = "booking_id"),  // khóa chính của Booking
            inverseJoinColumns = @JoinColumn(name = "slot_id")  // khóa chính của Slot
    )
    List<Slot> slots;

    @OneToMany(mappedBy = "booking", cascade = CascadeType.ALL)
    private List<BookingDetail> bookingDetails;

    @ManyToMany
    @JoinTable(
            name = "booking_service",
            joinColumns = @JoinColumn(name = "booking_id"),
            inverseJoinColumns = @JoinColumn(name = "service_id")
    )
    private List<Service> services;
}
