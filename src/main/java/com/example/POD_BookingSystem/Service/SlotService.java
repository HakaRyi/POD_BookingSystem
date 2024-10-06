package com.example.POD_BookingSystem.Service;

import com.example.POD_BookingSystem.DTO.Request.Slot.CreateSlotRequest;
import com.example.POD_BookingSystem.DTO.Request.Slot.UpdateSlotRequest;
import com.example.POD_BookingSystem.DTO.Response.SlotResponse;
import com.example.POD_BookingSystem.Entity.Slot;
import com.example.POD_BookingSystem.Exception.AppException;
import com.example.POD_BookingSystem.Exception.ErrorCode;
import com.example.POD_BookingSystem.Mapper.SlotMapper;
import com.example.POD_BookingSystem.Repository.SlotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SlotService {

    @Autowired
    SlotRepository slotRepository;
    @Autowired
    SlotMapper slotMapper;

    public SlotResponse createSlot(CreateSlotRequest request){
        Slot slot = Slot.builder()
                .slot_id(request.getSlot_id())
                .description(request.getDescription())
                .build();
        slotRepository.save(slot);
        return slotMapper.toSlotResponse(slot);
    }

    public List<SlotResponse> getAllSlot(){
        List<Slot> slots = slotRepository.findAll();
        return slots.stream().map(slotMapper::toSlotResponse).collect(Collectors.toList());
    }

    public Slot getSlot(String id){
        Slot slot = slotRepository.findById(id).orElseThrow(() -> new AppException(ErrorCode.ID_NOT_FOUND));
        return slot;
    }

    public SlotResponse updateSlot(String id, UpdateSlotRequest request){
        Slot slot = slotRepository.findById(id).orElseThrow(() -> new AppException(ErrorCode.ID_NOT_FOUND));
        slotMapper.updateSlot(slot,request);
        slotRepository.save(slot);
        return slotMapper.toSlotResponse(slot);
    }

    public void deleteSlot(String id){
        slotRepository.deleteById(id);
    }
}
