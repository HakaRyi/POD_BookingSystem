package com.example.POD_BookingSystem.Repository;

import com.example.POD_BookingSystem.Entity.Building;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BuildingRepository  extends JpaRepository<Building, String> {
    @Query(value = "Select building_id from Building order by building_id DESC LIMIT 1;", nativeQuery = true)
    public String findLastId();

    @Query(value = "SELECT * FROM Building WHERE name LIKE %:name%", nativeQuery = true)
    List<Building> findAllBuildingByName(@Param("name") String name);

    Building findByName(String name);

    boolean existsByName(String name);
}
