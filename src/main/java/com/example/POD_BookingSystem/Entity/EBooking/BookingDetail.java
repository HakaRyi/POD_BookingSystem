package com.example.POD_BookingSystem.Entity.EBooking;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;
import lombok.experimental.FieldDefaults;


import java.time.LocalDate;
import java.time.LocalDateTime;

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
    String room_id;
    String booking_id;
    String booking_type;
    String service_id;
    int quantity;
    double total_price;
    LocalDateTime timestamp;
    String status;
    LocalDate start_time;
    LocalDate end_time;
}
