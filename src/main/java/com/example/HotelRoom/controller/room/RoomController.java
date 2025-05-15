package com.example.HotelRoom.controller.room;


import com.example.HotelRoom.model.dto.ContractInfoDto;
import com.example.HotelRoom.model.dto.RoomInfoDto;
import com.example.HotelRoom.model.request.ContractRequest;
import com.example.HotelRoom.model.request.RoomRequest;
import com.example.HotelRoom.model.entity.Room;
import com.example.HotelRoom.model.request.RoomReservationReq;
import com.example.HotelRoom.service.room.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/room")
public class RoomController {

    private final RoomService roomService;

    @Autowired
    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    @GetMapping()
    public ResponseEntity<List<RoomInfoDto>> getAllRooms() {
        return roomService.getAllRooms();
    }

    @PostMapping("/create")

    public ResponseEntity<RoomInfoDto> create(@RequestBody RoomRequest body) {
        return roomService.createRoom(body);
    }


    @PostMapping("/reserved/{id}")
    public ResponseEntity<ContractInfoDto> createContract(@PathVariable String id, @RequestBody ContractRequest request) {
        return roomService.createContract(id, request);
    }

    @PostMapping("/cancel-reserved/{id}")
    public ResponseEntity<String> cancelReserved(@PathVariable String id) {
        return ResponseEntity.ok("s");
    }

    @GetMapping("{id}/contract")
    public ResponseEntity<ContractInfoDto> getContract(@PathVariable String id) {
        return roomService.getContract(id);
    }
}
