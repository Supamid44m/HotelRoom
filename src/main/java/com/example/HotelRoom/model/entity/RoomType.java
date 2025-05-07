package com.example.HotelRoom.model.entity;

import jakarta.persistence.*;
import lombok.Data;


@Data
@Entity
public class RoomType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "price_per_month")
    private Float pricePerMonth;

    @Column(name = "description")
    private String description;

}
