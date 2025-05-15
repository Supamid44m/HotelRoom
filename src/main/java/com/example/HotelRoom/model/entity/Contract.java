package com.example.HotelRoom.model.entity;


import jakarta.persistence.*;
import lombok.Data;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;

@Entity
@Data
public class Contract {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @OneToOne
    @JoinColumn(name = "room_id")
    private Room room;

//    private Tenant tenant;

    @ManyToOne
    @JoinColumn(name = "tenant_id")
    private Tenant tenant;

    private LocalDate startDate;
    private LocalDate endDate;

    private String status;

    private LocalDate createDate;
    private LocalDate updateDate;


}
