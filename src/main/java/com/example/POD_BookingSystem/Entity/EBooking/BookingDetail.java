package com.example.POD_BookingSystem.Entity.EBooking;

import com.example.POD_BookingSystem.Entity.Building;
import com.example.POD_BookingSystem.Entity.Room;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "booking_detail")
public class BookingDetail {
    @Id
    String booking_detail_id;
    String booking_type;
    String service_id;
    int quantity;
    double total_price;
    LocalDateTime timestamp;
    String status;
    LocalDate start_time;
    LocalDate end_time;
    String bookingVersion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "room_id", nullable = false)
    private Room room;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "booking_id")
    private Booking booking;

    @OneToMany(mappedBy = "bookingDetail", cascade = CascadeType.ALL)
    private List<Booking_service> bookingServices;
}
