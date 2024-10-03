package com.example.POD_BookingSystem.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name ="User")
public class User {
    @Id

    String userid_id;
    String name;
    String username;
    String password;
    String phone;
    String email;
    @ManyToOne
    @JoinColumn(name = "role_id",nullable = false, referencedColumnName = "role_id") // Thiết lập khóa ngoại
    Role role_id;
    //    String role_id;
    String VIP;


}