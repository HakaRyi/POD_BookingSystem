package com.example.POD_BookingSystem.service;
import com.example.POD_BookingSystem.entity.Role;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import com.example.POD_BookingSystem.dto.request.UserCreationRequest;
import com.example.POD_BookingSystem.dto.response.UserResponse;
import com.example.POD_BookingSystem.entity.User;
import com.example.POD_BookingSystem.enums.VIP;
import com.example.POD_BookingSystem.exception.AppException;
import com.example.POD_BookingSystem.exception.ErrorCode;
import com.example.POD_BookingSystem.mapper.UserMapper;
import com.example.POD_BookingSystem.repository.UserRepository;
import com.example.POD_BookingSystem.repository.RoleRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class UserService {
    @Autowired
    UserRepository userRepository;
    RoleRepository roleRepository;

    @Autowired
    UserMapper userMapper;

    public UserResponse createUser(UserCreationRequest request){
            Role role=roleRepository.findById("Role-01").orElseThrow();
        if(userRepository.existsByUsername(request.getUsername()))   //kiểm tra user tồn tại hay ko
            throw new AppException(ErrorCode.USER_EXISTED);
        User user = userMapper.toUser(request);
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(10);
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setUserid_id(GenerateId());
        user.setRole_id(role);
        user.setVIP(VIP.INACTIVE.name());
        return userMapper.toUserResponse(userRepository.save(user));

    }
    private String GenerateId(){
        String id = userRepository.findLastId();
        if(!(id == null)){
            int number = Integer.parseInt(id.substring(3))+1;
            return String.format("U-%02d", number);
        }
        return "U-01";
    }

}