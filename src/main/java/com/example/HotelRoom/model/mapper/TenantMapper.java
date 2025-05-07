package com.example.HotelRoom.model.mapper;

import com.example.HotelRoom.model.dto.TenantInfoDto;
import com.example.HotelRoom.model.entity.Tenant;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface TenantMapper extends GenericMapper<Tenant, TenantInfoDto> {

    TenantInfoDto toDto(Tenant tenant);

    Tenant toEntity(TenantInfoDto tenantInfoDto);
}
