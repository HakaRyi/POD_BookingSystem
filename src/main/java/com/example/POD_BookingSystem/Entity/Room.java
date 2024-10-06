package com.example.POD_BookingSystem.Entity;

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
@Table(name = "Room")
public class Room {
    @Id
    String room_id;
    String room_name;
    int capacity;
    String availability;
    double price;
    String description;
    @Column(name = "availeble_Date")
    LocalDate  available_Date;

    //Quan He 1 Nhieu Voi BUILDING
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "building_id")
    private Building building;

    //Quan He 1 Nhieu voi RoomType
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "type_id")
    private Room_Type roomType;

    @ManyToMany(mappedBy = "rooms")
    List<Service> services;
}
