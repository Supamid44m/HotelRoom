package com.example.HotelRoom.constant.room;

public class Reservation {

    public enum Status {
        BOOKED,
        CANCELLED,
        CHECK_IN,
        CHECK_OUT
    }

    public enum Type {
        DAY,
        MONTH
    }
}
