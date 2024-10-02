package com.example.POD_BookingSystem.Mapper;

import com.example.POD_BookingSystem.Entity.Building;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoomRepository extends JpaRepository<Building, String> {
    @Query(value = "Select room_id from Room order by room_id DESC LIMIT 1;", nativeQuery = true)
    public String findLastId();
    @Query(value = "SELECT * FROM Room WHERE  LIKE %:name%", nativeQuery = true)
    List<Building> findAllBuildingByName(@Param("name") String name);
}
