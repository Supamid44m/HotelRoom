package com.example.HotelRoom.model.dto;


import jakarta.persistence.Column;
import lombok.Data;

@Data
public class RoomTypeDto {

    private String name;

    private Float pricePerMonth;

    private String description;
}
