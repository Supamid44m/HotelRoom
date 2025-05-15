package com.example.HotelRoom.model.mapper;

import com.example.HotelRoom.model.dto.ContractInfoDto;
import com.example.HotelRoom.model.entity.Contract;

public interface ContractMapper extends GenericMapper<Contract, ContractInfoDto> {


    ContractInfoDto toDto(Contract contract);

}
