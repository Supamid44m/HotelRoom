package com.example.HotelRoom.model.entity;


import com.example.HotelRoom.constant.room.ReservationConstant;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "reservation")
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @ManyToOne(optional = false)
    @JoinColumn(name = "room_id", nullable = false)
    private Room room;


    @Column(name = "check_in_date")
    private LocalDate checkInDate;

    @Column(name = "check_out_date")
    private LocalDate checkOutDate;

    @Enumerated(EnumType.STRING)
    private ReservationConstant.Status status;

    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    private ReservationConstant.Type type;
}
