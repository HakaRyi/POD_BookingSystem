package com.example.POD_BookingSystem.controller;

import com.example.POD_BookingSystem.dto.request.UserCreationRequest;
import com.example.POD_BookingSystem.dto.response.ApiResponse;
import com.example.POD_BookingSystem.dto.response.UserResponse;
import com.example.POD_BookingSystem.service.UserService;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping
    ApiResponse<UserResponse> createUser(@RequestBody @Valid UserCreationRequest request){

        ApiResponse<UserResponse> apiResponse=new ApiResponse<>();

        apiResponse.setResult(userService.createUser(request));

        return apiResponse;
    }

}