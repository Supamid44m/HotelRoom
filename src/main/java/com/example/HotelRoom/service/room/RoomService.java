package com.example.HotelRoom.service;


import com.example.HotelRoom.model.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoomService {

    private final RoomRepository roomRepository;

    @Autowired
    public RoomService(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    public String reservation(){
        return "reservetion";
    }


    public String checkIn(String id) {
        return "room check in" + id;
    }

    public String checkOut(String id) {
        return "check out";
    }
}
