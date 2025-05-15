package com.example.HotelRoom.model.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class ContractInfoDto {

    private LocalDate startDate;
    private LocalDate endDate;
    private RoomInfoDto roomInfo;
    private TenantInfoDto tenantInfo;

}
