package com.example.POD_BookingSystem.Service;

import com.example.POD_BookingSystem.DTO.Request.User.RoleRequest;
import com.example.POD_BookingSystem.Entity.Role;
import com.example.POD_BookingSystem.Repository.RoleRepository;
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
public class RoleService {
    @Autowired
    RoleRepository roleRepository;

    public Role createRole(RoleRequest request){
        Role role = Role.builder()
                .role_id(GenerateId())
                .roleName(request.getRoleName())
                .build();
//        role.setRoleName(request.getRoleName());
        roleRepository.save(role);
        log.info(role.getRoleName());
        return role ;

    }
    private String GenerateId(){
        String id = roleRepository.findLastId();
        if (id != null && id.startsWith("Role-")) {
            try {
                int number = Integer.parseInt(id.substring(5)) + 1;  // Bắt đầu từ vị trí 5, không phải 3
                return String.format("Role-%02d", number);
            } catch (NumberFormatException e) {
                // Xử lý ngoại lệ nếu không thể chuyển đổi thành số
                System.err.println("Invalid ID format: " + id);
            }
        }
        return "Role-01";
    }

}