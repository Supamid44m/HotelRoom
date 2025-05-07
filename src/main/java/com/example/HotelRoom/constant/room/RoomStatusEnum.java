package com.example.HotelRoom.constant.room;


import lombok.Data;
import lombok.Getter;

@Getter
public enum RoomStatusEnum {
    EMPTY("empty"),
    RESERVED("reserved"),
    NOT_EMPTY("not_empty");

    private final String value;

    RoomStatusEnum(String value) {
        this.value = value;
    }
}
