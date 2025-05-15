package com.example.HotelRoom.model.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;

@Entity
@Data
public class Contract {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long roomId;

    private Long tenantId;

    private LocalDate startDate;
    private LocalDate endDate;

    private String status;

    private LocalDate createDate;
    private LocalDate updateDate;


}
