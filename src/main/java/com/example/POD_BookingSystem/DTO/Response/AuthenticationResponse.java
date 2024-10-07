package com.example.POD_BookingSystem.dto.response;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AuthenticationResponse {

    String token;
    boolean authenticated; //true => user cung cấp user pass đúng và ngược lại
}