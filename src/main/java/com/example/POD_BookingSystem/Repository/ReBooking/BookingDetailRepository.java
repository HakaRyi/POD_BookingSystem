package com.example.POD_BookingSystem.Repository.ReBooking;

import com.example.POD_BookingSystem.Entity.EBooking.Booking;
import com.example.POD_BookingSystem.Entity.EBooking.BookingDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingDetailRepository extends JpaRepository<BookingDetail, String> {
    @Query("Select * from booking_detail where booking_id = :booking_id")
    List<BookingDetail> findAllBookingDetailInBooking(@Param("booking_id") String id);

    @Query(value = "Select booking_detail_id from booking_detail order by booking_detail_id DESC LIMIT 1;", nativeQuery = true)
    public String findLastId();

    @Query(value = "Select bookingVersion from booking_detail order by bookingVersion DESC LIMIT 1;", nativeQuery = true)
    public String findLastVersion();

    @Query(value = "Select * from booking_detail where bookingVersion = :version")
    public List<BookingDetail> findAllBookingDetailInVersion(@Param("version")String version);
}
