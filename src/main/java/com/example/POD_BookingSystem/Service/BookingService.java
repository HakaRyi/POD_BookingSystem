package com.example.POD_BookingSystem.Service;

import com.example.POD_BookingSystem.DTO.Request.Booking.CreateBookingDetailRequest;
import com.example.POD_BookingSystem.DTO.Request.Booking.CreateBookingRequest;
import com.example.POD_BookingSystem.DTO.Response.BookingDetailResponse;
import com.example.POD_BookingSystem.DTO.Response.BookingResponse;
import com.example.POD_BookingSystem.Entity.EBooking.Booking;
import com.example.POD_BookingSystem.Entity.EBooking.BookingDetail;
import com.example.POD_BookingSystem.Entity.Room;
import com.example.POD_BookingSystem.Entity.Slot;
import com.example.POD_BookingSystem.Exception.AppException;
import com.example.POD_BookingSystem.Exception.ErrorCode;
import com.example.POD_BookingSystem.Mapper.MBooking.BookingDetailMapper;
import com.example.POD_BookingSystem.Repository.ReBooking.BookingDetailRepository;
import com.example.POD_BookingSystem.Repository.ReBooking.BookingRepository;
import com.example.POD_BookingSystem.Repository.ReRoom.RoomRepository;
import com.example.POD_BookingSystem.Repository.ServiceRepository;
import com.example.POD_BookingSystem.Repository.SlotRepository;
import com.example.POD_BookingSystem.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BookingService {
    @Autowired
    BookingRepository bookingRepository;

    @Autowired
    BookingDetailRepository bookingDetailRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoomRepository roomRepository;

    @Autowired
    ServiceRepository serviceRepository;

    @Autowired
    BookingDetailMapper bookingDetailMapper;

    @Autowired
    SlotRepository slotRepository;

//     CREATE BOOKING
    public Booking createBooking (CreateBookingRequest request, String userName){
        List<BookingDetail> bookingDetails = bookingDetailRepository.findAllBookingDetailInVersion(request.getBookingVersion());
        List<com.example.POD_BookingSystem.Entity.Service> services = null;
        for(BookingDetail bookingDetail: bookingDetails){
            services.add(serviceRepository.findById(bookingDetail.getService_id()).orElseThrow(() -> new AppException(ErrorCode.ID_NOT_FOUND)));
        }

        Booking booking = Booking.builder()
                .booking_id(GenerateId())
                .user_id(userRepository.findByUsername(userName).
                        orElseThrow(() -> new RuntimeException("User does not Exist")).getUserid_id())
                .booking_date(LocalDate.now())
                .bookingDetails(bookingDetails)
                .total(request.getTotal())
                .services(services)
                .build();
        bookingRepository.save(booking);
        return booking;
    }
//        public BookingDetail getBookingDetail(){
//
//    }

    public BookingDetailResponse createBookingDetail(String roomName, CreateBookingDetailRequest request) {
        Room room = roomRepository.findRoomByName(roomName);
        if (room == null) throw new RuntimeException("Room does not Exist");
        String version = GenerateDetailVesion();


        //Lay Thoi Gian Thue Phong
        Duration duration = Duration.between(request.getStart_time(), request.getEnd_time());
        List<Slot> slots = null;
        int numberOfSlot = 0;
        for(String slotId : request.getSlots()){
            slots.add(slotRepository.findById(slotId).orElseThrow(() -> new AppException(ErrorCode.ID_NOT_FOUND)));
            numberOfSlot += 1;
        }
        long timeBooking = 0;
        double bookingPrice = 0;
        if(slots.getFirst().getSlot_id().equals("Day")){
            timeBooking = duration.toDays();
            bookingPrice = (room.getPrice()*12) * 10 / 100;
        } else if (slots.getFirst().getSlot_id().equals("Month")) {
            timeBooking = duration.toDays()/30;
            bookingPrice = (room.getPrice()*timeBooking) * 15 / 100;
        } else {
            timeBooking = numberOfSlot;
            bookingPrice = room.getPrice()*timeBooking;
        }

        //Lay Slot Thue Cho Booking Detail
        List<String> slotDescription = null;
        for(Slot slot : slots){
            slotDescription.add(slot.getDescription());
        }

        List<BookingDetail> bookingDetails = new ArrayList<>();
        int quantity = 1;

        double bookingTotalPrice = 0;

        BookingDetail roomBookingDetail = BookingDetail.builder()
                .booking_detail_id(GenerateDetailId())
                .room(room)
                .booking_type("ROOM")
                .service_id("")
                .quantity(quantity)
                .total_price(bookingPrice)
                .timestamp(LocalDateTime.now())
                .status("CONFIRM")
                .start_time(request.getStart_time())
                .end_time(request.getEnd_time())
                .bookingVersion(version)
                .build();

        bookingDetailRepository.save(roomBookingDetail);
        bookingTotalPrice += bookingPrice;

        Map<String, Integer> service = new HashMap<>();
        // Tao Booking Detail cho List Service
        int number = Integer.parseInt(GenerateDetailId().substring(3));
        for(Map.Entry<String, Integer> entry : request.getService().entrySet()){
            String serviceId = entry.getKey(); // Lấy serviceId
            Integer Quantity = entry.getValue();
            number += 1;
            String id = String.format("BD-%02d", number);

            com.example.POD_BookingSystem.Entity.Service Service = serviceRepository.findById(serviceId).orElseThrow
                    (() -> new AppException(ErrorCode.ID_NOT_FOUND));
            BookingDetail serviceBookingDetail = BookingDetail.builder()
                    .booking_detail_id(id)
                    .booking_type("SERVICE")
                    .service_id(serviceId)
                    .quantity(Quantity)
                    .total_price(Service.getPrice() * Quantity)
                    .timestamp(LocalDateTime.now())
                    .status("CONFIRM")
                    .start_time(request.getStart_time())
                    .end_time(request.getEnd_time())
                    .bookingVersion(version)
                    .build();

            bookingDetailRepository.save(serviceBookingDetail);
            bookingTotalPrice += (Service.getPrice() * Quantity);
            service.put(serviceId,Quantity);
        }

        return BookingDetailResponse.builder()
                .bookingVersion(version)
                .slotDescription(slotDescription)
                .service(service)
                .end_time(request.getEnd_time())
                .start_time(request.getStart_time())
                .total_price(bookingTotalPrice)
                .build();
    }

    public BookingDetailResponse createBookingDetailForPayment(String roomName, CreateBookingDetailRequest request) {
        Room room = roomRepository.findRoomByName(roomName);
        if (room == null) throw new RuntimeException("Room does not Exist");
        String version = GenerateDetailVesion();


        //Lay Thoi Gian Thue Phong
        Duration duration = Duration.between(request.getStart_time(), request.getEnd_time());
        List<Slot> slots = null;
        int numberOfSlot = 0;
        for(String slotId : request.getSlots()){
            slots.add(slotRepository.findById(slotId).orElseThrow(() -> new AppException(ErrorCode.ID_NOT_FOUND)));
            numberOfSlot += 1;
        }
        long timeBooking = 0;
        double bookingPrice = 0;
        if(slots.getFirst().getSlot_id().equals("Day")){
            timeBooking = duration.toDays();
            bookingPrice = (room.getPrice()*12) * 10 / 100;
        } else if (slots.getFirst().getSlot_id().equals("Month")) {
            timeBooking = duration.toDays()/30;
            bookingPrice = (room.getPrice()*timeBooking) * 15 / 100;
        } else {
            timeBooking = numberOfSlot;
            bookingPrice = room.getPrice()*timeBooking;
        }

        //Lay Slot Thue Cho Booking Detail
        List<String> slotDescription = null;
        for(Slot slot : slots){
            slotDescription.add(slot.getDescription());
        }

        List<BookingDetail> bookingDetails = new ArrayList<>();

        double bookingTotalPrice = 0;

        bookingTotalPrice += bookingPrice;

        Map<String, Integer> service = new HashMap<>();
        // Tao Booking Detail cho List Service
        for(Map.Entry<String, Integer> entry : request.getService().entrySet()){
            String serviceId = entry.getKey(); // Lấy serviceId
            Integer Quantity = entry.getValue();

            com.example.POD_BookingSystem.Entity.Service Service = serviceRepository.findById(serviceId).orElseThrow
                    (() -> new AppException(ErrorCode.ID_NOT_FOUND));

            bookingTotalPrice += (Service.getPrice() * Quantity);
            service.put(serviceId,Quantity);
        }

        return BookingDetailResponse.builder()
                .bookingVersion(version)
                .slotDescription(slotDescription)
                .service(service)
                .end_time(request.getEnd_time())
                .start_time(request.getStart_time())
                .total_price(bookingTotalPrice)
                .build();
    }

    //Tao ra 1 Id tang dan dua tren Id da co
    private String GenerateId(){
        String id = bookingRepository.findLastId();
        if(!(id == null)){
            int number = Integer.parseInt(id.substring(3))+1;
            return String.format("Bo-%02d", number);
        }
        return "Bo-01";
    }

    private String GenerateDetailId(){
        String id = bookingDetailRepository.findLastId();
        if(!(id == null)){
            int number = Integer.parseInt(id.substring(3))+1;
            return String.format("BD-%02d", number);
        }
        return "BD-01";
    }

    //Tao ra 1 Version moi, tang dan dua tren version da co
    private String GenerateDetailVesion(){
        String version = bookingDetailRepository.findLastVersion();
        if(!(version == null)){
            int number = Integer.parseInt(version.substring(8))+1;
            return String.format("bookingV%02d", number);
        }
        return "bookingV01";
    }

}
