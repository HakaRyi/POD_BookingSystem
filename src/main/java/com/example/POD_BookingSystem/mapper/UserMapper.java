package com.example.POD_BookingSystem.mapper;



import com.example.POD_BookingSystem.DTO.Request.User.UserCreationRequest;
import com.example.POD_BookingSystem.DTO.Request.User.UserUpdateRequest;
import com.example.POD_BookingSystem.dto.response.UserResponse;
import com.example.POD_BookingSystem.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;


//method này sẽ nhận về 1 cái tham số là request theo kiểu UserCreationRequest và trả về cho chúng ta 1 cái class là User

@Mapper(componentModel = "spring")
public interface UserMapper {
    User toUser(UserCreationRequest request);


    UserResponse toUserResponse(User user);

    void updateUser(@MappingTarget User user, UserUpdateRequest request);

}