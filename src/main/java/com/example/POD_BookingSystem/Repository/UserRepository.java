package com.example.POD_BookingSystem.repository;

import com.example.POD_BookingSystem.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,String> {

    boolean existsByUsername(String username);
    Optional<User> findByUsername(String username);
    @Query(value = "Select * from User where name like %:name% and role_id='Role-03'", nativeQuery = true)
    public User findName(@Param("name") String name);
    @Query(value = "Select userid_id from User order by userid_id DESC LIMIT 1;", nativeQuery = true)
    public String findLastId();
}