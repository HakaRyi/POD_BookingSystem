package com.example.POD_BookingSystem.repository;

import com.example.POD_BookingSystem.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role,String> {
     //    Optional<Role> findByRolename(String roleName);
     @Query(value = "Select role_id from Role order by role_id DESC LIMIT 1;", nativeQuery = true)
     public String findLastId();
}