package com.example.POD_BookingSystem.Repository.ReBooking;

import com.example.POD_BookingSystem.Entity.EBooking.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingDetailRepository extends JpaRepository<Booking, String> {

}
