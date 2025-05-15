package com.example.HotelRoom.model.mapper;

import com.example.HotelRoom.model.dto.ContractInfoDto;
import com.example.HotelRoom.model.entity.Contract;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ContractMapper extends GenericMapper<Contract, ContractInfoDto> {




    ContractInfoDto toDto(Contract contract);

    List<ContractInfoDto> toDtoList(List<Contract> contracts);

    Contract toEntity(ContractInfoDto contractInfoDto);

}
