package com.example.HotelRoom.model.mapper;

import com.example.HotelRoom.model.dto.RoomTypeDto;
import com.example.HotelRoom.model.entity.RoomType;
import org.mapstruct.Mapper;

@Mapper
public interface RoomTypeMapper extends GenericMapper<RoomType, RoomTypeDto> {

    RoomTypeDto toDto(RoomType roomType);

}
