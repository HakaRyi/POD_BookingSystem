package com.example.POD_BookingSystem.Repository;

import com.example.POD_BookingSystem.Entity.Building;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BuildingRepository  extends JpaRepository<Building, String> {
    @Query(value = "Select building_id from Building order by building_id DESC LIMIT 1;", nativeQuery = true)
    public String findLastId();
}
