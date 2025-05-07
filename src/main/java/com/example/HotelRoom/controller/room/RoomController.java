package com.example.HotelRoom.controller.room;


import com.example.HotelRoom.model.dto.RoomInfoDto;
import com.example.HotelRoom.model.request.RoomRequest;
import com.example.HotelRoom.model.entity.Room;
import com.example.HotelRoom.model.request.RoomReservationReq;
import com.example.HotelRoom.service.room.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/room")
public class RoomController {

    private final RoomService roomService;

    @Autowired
    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    @PostMapping("/create")
    public ResponseEntity<RoomInfoDto> create(@RequestBody RoomRequest body) {
        return roomService.createRoom(body);
    }

//    @GetMapping("/{roomId}/info")
//
//
//    @PostMapping("/reservation")
//    public void reserved(@RequestBody RoomReservationReq req) {
//        roomService.reserved(req);
//    }
//
//    @GetMapping("/cancel-reservation/{roomId}")
//    public void cancelReserved(@PathVariable Long roomId) {
//        roomService.cancelReserved(roomId);
//    }


}
