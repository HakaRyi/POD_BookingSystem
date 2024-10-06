package com.example.POD_BookingSystem.repository;

import com.example.POD_BookingSystem.entity.Building;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BuildingRepository extends JpaRepository<Building, String > {
    @Query(value = "Select building_id from Building order by building_id DESC LIMIT 1;", nativeQuery = true)
    public String findLastId();

    @Query(value = "SELECT * FROM Building WHERE name LIKE %:name%", nativeQuery = true)
    List<Building> findAllByName(@Param("name") String name);

    @Query(value = "SELECT * FROM Building WHERE location LIKE %:location%", nativeQuery = true)
    List<Building> findAllByLocation(@Param("location") String name);

    Building findByName(String building_name);

    boolean existsByName(String building_name);
}
