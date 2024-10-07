package com.example.POD_BookingSystem.Service;

import com.example.POD_BookingSystem.Repository.ReBooking.BookingDetailRepository;
import com.example.POD_BookingSystem.Repository.ReBooking.BookingRepository;
import com.example.POD_BookingSystem.Repository.SlotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookingService {
    @Autowired
    BookingRepository bookingRepository;

    @Autowired
    BookingDetailRepository bookingDetailRepository;

//    @Autowired

}
