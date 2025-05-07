package com.example.HotelRoom.model.mapper;

import com.example.HotelRoom.model.dto.RoomInfoDto;
import com.example.HotelRoom.model.entity.Room;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface RoomMapper extends GenericMapper<Room, RoomInfoDto> {

    RoomInfoDto toDto(Room room);


//    @BeanMapping
//    Room partialUpdate(RoomInfoDto roomInfoDto, @MappingTarget Room room);
}
