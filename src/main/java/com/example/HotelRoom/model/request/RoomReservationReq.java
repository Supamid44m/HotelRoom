package com.example.HotelRoom.model.request;


//import com.example.HotelRoom.model.entity.Reservation;

import com.example.HotelRoom.constant.room.ReservationConstant;
import lombok.Data;

import java.time.LocalDate;

@Data
public class RoomReservationReq {

    private Long roomId;

    private LocalDate checkInDate = LocalDate.now();

    private LocalDate checkOutDate = LocalDate.now();

    private ReservationConstant.Status status;

    private ReservationConstant.Type type;

}
