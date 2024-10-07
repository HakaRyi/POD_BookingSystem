package com.example.POD_BookingSystem.DTO.Response;


//class chua cac fill de chuan hoa API

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import lombok.experimental.FieldDefaults;

@JsonInclude(JsonInclude.Include.NON_NULL)   //annotation khai bao khi co bien=null thi ko hien ra

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)

public class ApiResponse<T> {
    @Builder.Default int code=1000; // neu API tra code=1000 la API co ket qua thanh cong
    String message;
    T data;   //kieu du lieu T co the thay doi tuy vao tung API

}