package com.example.HotelRoom.service.room;


import com.example.HotelRoom.constant.room.ReservationConstant;
import com.example.HotelRoom.constant.room.RoomStatusEnum;
import com.example.HotelRoom.model.dto.RoomInfoDto;
import com.example.HotelRoom.model.dto.TenantInfoDto;
import com.example.HotelRoom.model.entity.Reservation;
import com.example.HotelRoom.model.entity.Room;
import com.example.HotelRoom.model.entity.RoomType;
import com.example.HotelRoom.model.mapper.RoomMapper;
import com.example.HotelRoom.model.repository.ReservationRepository;
import com.example.HotelRoom.model.repository.RoomRepository;
import com.example.HotelRoom.model.repository.RoomTypeRepository;
import com.example.HotelRoom.model.request.RoomRequest;
import com.example.HotelRoom.model.request.RoomReservationReq;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class RoomService {

    private final RoomRepository roomRepository;
    private final ReservationRepository reservationRepository;
    private final RoomTypeRepository roomTypeRepository;
    private final RoomMapper roomMapper;

    @Autowired
    public RoomService(RoomRepository roomRepository, ReservationRepository reservationRepository, RoomTypeRepository roomTypeRepository, RoomMapper roomMapper) {
        this.roomRepository = roomRepository;
        this.reservationRepository = reservationRepository;
        this.roomTypeRepository = roomTypeRepository;
        this.roomMapper = roomMapper;
    }


    public ResponseEntity<RoomInfoDto> createRoom(RoomRequest body) {
        try {
            Room room = new Room();
            RoomType roomType = roomTypeRepository.findById(body.getRoomTypeId()).orElseThrow(() -> new RuntimeException("Room Type not found"));
            room.setRoomNumber(body.getRoomNumber());
            room.setRoomType(roomType);
            roomRepository.save(room);

            RoomInfoDto dto = roomMapper.toDto(room);

            return ResponseEntity.ok(dto);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    public ResponseEntity<TenantInfoDto> createContract() {
        try {

//            return ResponseEntity.ok("");
        } catch (Exception error) {
            throw new RuntimeException(error);
        }
    }
}
