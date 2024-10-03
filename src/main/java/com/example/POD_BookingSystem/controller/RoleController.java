package com.example.POD_BookingSystem.controller;

import com.example.POD_BookingSystem.dto.request.RoleRequest;
import com.example.POD_BookingSystem.dto.response.ApiResponse;
import com.example.POD_BookingSystem.entity.Role;
import com.example.POD_BookingSystem.service.RoleService;
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
@RequestMapping("/api/roles")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class RoleController {
    @Autowired
    RoleService roleService;

    @PostMapping
    ApiResponse<Role> createUser(@RequestBody @Valid RoleRequest request){

        ApiResponse<Role> apiResponse=new ApiResponse<>();

        apiResponse.setResult(roleService.createRole(request));

        return apiResponse;
    }
}