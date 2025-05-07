package com.example.HotelRoom.model.dto;


import com.example.HotelRoom.constant.room.RoomStatusEnum;
import com.example.HotelRoom.model.entity.RoomType;
import lombok.Data;

@Data
public class RoomInfoDto {

    private String roomNumber;
    private RoomStatusEnum status;
    private RoomTypeDto roomType;
}
